DROP DATABASE IF EXISTS shareForcast;

CREATE DATABASE shareForcast;
USE shareForcast;
CREATE TABLE USERINFORMATION
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
ratio_id int,
PRIMARY KEY (id)
);

CREATE TABLE COMPANYINFORMATION
(
accord_id int NOT NULL,
shian_id int NOT NULL,
bse_id int,
nse_id varchar(25),
company_name varchar(255) NOT NULL,
bse_listed TINYINT(1) NOT NULL,
nse_listed TINYINT(1) NOT NULL,
group_name varchar(255),
market_cap varchar(255),
PRIMARY KEY (accord_id, shian_id)
);

CREATE TABLE PERIOD
(
time_id int NOT NULL,
time_value varchar(255) NOT NULL,
PRIMARY KEY (time_id)
);

CREATE TABLE RATIOS
(
ratio_id int NOT NULL,
ratio_name varchar(255) NOT NULL,
query_value varchar(1000),
PRIMARY KEY (ratio_id)
);
