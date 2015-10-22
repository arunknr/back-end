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
bse_listed varchar(1) NOT NULL,
nse_listed varchar(1) NOT NULL,
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
attribute1 varchar(255),
attribute2 varchar(255),
attribute3 varchar(255),
attribute4 varchar(255),
attribute5 varchar(255),
attribute6 varchar(255),
attribute7 varchar(255),
attribute8 varchar(255),
attribute9 varchar(255),
attribute10 varchar(255),
PRIMARY KEY (ratio_id)
);
