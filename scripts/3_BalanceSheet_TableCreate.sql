CREATE TABLE BALANCESHEET
(
balancesheet_id int NOT NULL,
level_id int NOT NULL,
value_required TINYINT(1),
bold_required TINYINT(1),
balancesheet_name varchar(255),
PRIMARY KEY (balancesheet_id));

CREATE TABLE BALANCESHEETVALUES
(
shian_id int NOT NULL,
time_id int NOT NULL,
report_period int NOT NULL,
balancesheet_id int NOT NULL,
balancesheet_value varchar(255),
PRIMARY KEY (shian_id,time_id,report_period,balancesheet_id)
);