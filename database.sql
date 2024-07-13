create database RegisterLogin_restful_api;
use RegisterLogin_restful_api;


CREATE TABLE users(
    username VARCHAR(100) NOT NULL ,
    password VARCHAR(100) NOT NULL ,
    surel VARCHAR(100) NOT NULL ,
    token VARCHAR(100),
    token_expired_at BIGINT,
    primary key (username),
    UNIQUE (token)
)ENGINE innoDB

select * from users;
DESC users;

delete from users;