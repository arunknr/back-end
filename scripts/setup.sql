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

CREATE TABLE COMPANYSHAREVALUE
(
company_id int NOT NULL,
company_name varchar(255) NOT NULL,
eps double NOT NULL,
face_value double NOT NULL,
market_cap double NOT NULL,
price double NOT NULL,
PRIMARY KEY (company_id)
);