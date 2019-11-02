package com.example.AbrahamLealU12M3Summative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        authenticationManagerBuilder
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?")
                .passwordEncoder(passwordEncoder);
    }

    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();
        httpSecurity
                .authorizeRequests()
                .mvcMatchers(HttpMethod.PUT,"/games").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.PUT,"/consoles").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.PUT, "/tshirts").hasAuthority("ROLE_STAFF")
                .mvcMatchers(HttpMethod.POST, "/purchases").permitAll()
                .mvcMatchers(HttpMethod.POST, "/games").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/consoles").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.POST, "/tshirts").hasAuthority("ROLE_MANAGER")
                .mvcMatchers(HttpMethod.DELETE,"/games/*").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/consoles/*").hasAuthority("ROLE_ADMIN")
                .mvcMatchers(HttpMethod.DELETE,"/tshirts/*").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll();

        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XREF-TOKEN")
                .invalidateHttpSession(true);

        httpSecurity.csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }
}
