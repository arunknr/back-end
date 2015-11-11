CREATE TABLE BALANCESHEET
(
balancesheet_id int NOT NULL,
level_indicator int NOT NULL,
value_required TINYINT(1),
bold_required TINYINT(1),
name varchar(255),
PRIMARY KEY (balancesheet_id));

CREATE TABLE BALANCESHEETVALUES
(
company_id int NOT NULL,
time_id int NOT NULL,
report_period int NOT NULL,
balancesheet_id int NOT NULL,
balancesheet_value double(16,2),
PRIMARY KEY (company_id,time_id,report_period,balancesheet_id),
FOREIGN KEY (balancesheet_id) REFERENCES BALANCESHEET(balancesheet_id)
);