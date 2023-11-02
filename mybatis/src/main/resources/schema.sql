CREATE TABLE users (
    id bigint not null auto_increment,
    name varchar(255) not null,
    address varchar(255) not null,
    primary key(id)
);

CREATE TABLE prac (
    id varchar(30) primary key,
    pw varchar(255) not null,
    nick varchar(30) not null
);