DROP DATABASE IF EXISTS shareForcast;

CREATE DATABASE shareForcast;
USE shareForcast;
CREATE TABLE USER
(
id int NOT NULL AUTO_INCREMENT,
user_name varchar(255) NOT NULL,
password varchar(255) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE SHAREKEYWORDS
(
id int NOT NULL AUTO_INCREMENT,
key_words varchar(255) NOT NULL,
PRIMARY KEY (id)
);