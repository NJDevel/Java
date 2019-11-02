use game_store;

create table if not exists users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);

create table if not exists authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username));
	create unique index ix_auth_username on authorities (username,authority
);


insert into users (username, password, enabled) values ('staffUser', '$2a$10$A7WMdaIVKbNWPmAbBirdZOBWLyI/KtV2wnOrbnzj986pmEXbWlu.u', true);
insert into users (username, password, enabled) values ('managerUser', '$$2a$10$dVaweMqWSu3nVV9IKzMHv.4Nn7ChazvBjaVp6T6ymWpYZ1WJ7Wc5K', true);
insert into users (username, password, enabled) values ('adminUser', '$2a$10$IxbmnPZ9wYpoWu//k9.G6O5NgiTLhubrErg.SjpIkbw.yBszC1Vui', true);

insert into authorities (username, authority) values ('staffUser', 'ROLE_STAFF');
insert into authorities (username, authority) values ('managerUser', 'ROLE_STAFF');
insert into authorities (username, authority) values ('managerUser', 'ROLE_MANAGER');
insert into authorities (username, authority) values ('adminUser', 'ROLE_STAFF');
insert into authorities (username, authority) values ('adminUser', 'ROLE_MANAGER');
insert into authorities (username, authority) values ('adminUser', 'ROLE_ADMIN');
