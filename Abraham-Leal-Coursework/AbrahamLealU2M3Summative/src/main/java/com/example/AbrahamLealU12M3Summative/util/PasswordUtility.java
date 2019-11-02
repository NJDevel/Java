package com.example.AbrahamLealU12M3Summative.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String password = "adminPass";

        String encodedPassword = passwordEncoder.encode(password);
        System.out.println(encodedPassword);
    }
}
