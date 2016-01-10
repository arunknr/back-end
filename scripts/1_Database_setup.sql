DROP DATABASE IF EXISTS shareForcast;

CREATE DATABASE shareForcast;
USE shareForcast;
CREATE TABLE USERINFORMATION
(
id int NOT NULL AUTO_INCREMENT,
username varchar(255) NOT NULL,
password varchar(255) NOT NULL,
firstname varchar(255),
lastname varchar(255),
email varchar(255),
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
company_id int NOT NULL,
accord_id int NOT NULL,
bse_id int,
nse_id varchar(25),
company_name varchar(255) NOT NULL,
bse_listed TINYINT(1) NOT NULL,
nse_listed TINYINT(1) NOT NULL,
industry varchar(255),
market_cap varchar(255),
PRIMARY KEY (company_id)
);

CREATE TABLE PERIOD
(
id int NOT NULL,
name varchar(255) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE RATIOS
(
id int NOT NULL,
name varchar(255) NOT NULL,
formula varchar(1000),
PRIMARY KEY (id)
);

CREATE TABLE RATIOVALUES
(
company_id int NOT NULL,
time_id int NOT NULL,
report_period int NOT NULL,
ratio_id int NOT NULL,
ratio_value double(10,2),
PRIMARY KEY (company_id,time_id,report_period,ratio_id),
FOREIGN KEY (ratio_id) REFERENCES RATIOS(id)
);
