create table users (id bigserial, username varchar(200) not null, password varchar(250) not null, primary key (id));

create table roles (id serial, name varchar(100) not null, primary key (id));

create table score (id bigserial, points int not null, primary key (id));

create table users_roles (user_id bigint not null, role_id int not null, primary key (user_id, role_id), foreign key (user_id) references users (id), foreign key (role_id) references roles (id));

create table users_scores (user_id bigint not null, score_id int not null, primary key (user_id, score_id), foreign key (user_id) references users (id), foreign key (score_id) references score (id));

insert into users (username, password) values
--  пароль: 101
('Bob', '$2y$12$w.xH5n2fP9cl2mLm2mSR/OaccV9/fYFmAjuwM270NTZiCk/8OwA62 '),
--  пароль: 102
('Alex', '$2y$12$R.S5qDof1BQdG/efA092CuUPJvG4gi1MelBc/BwyzVW/rTyaMho1a '),
--  пароль: 103
('Masha', '$2y$12$dECbBIR4wLgm.v8Xn4X9YuUXIb0TmogfJgTfUJULG6MnHi2NziRzS ');

insert into roles (name) values
('ROLE_USER'), ('ROLE_ADMIN');

insert into score (points) values
(10), (20), (30), (40), (50), (60), (70), (80), (90), (100);

insert into users_roles (user_id, role_id) values
(1, 1), (2, 1), (3, 2);

insert into users_scores (user_id, score_id) values
(1, 6), (2, 7), (3, 9);