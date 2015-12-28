CREATE TABLE CASHFLOW
(
id int NOT NULL,
level_indicator int NOT NULL,
value_required TINYINT(1),
bold_required TINYINT(1),
name varchar(255),
PRIMARY KEY (id));

CREATE TABLE CASHFLOWVALUES
(
company_id int NOT NULL,
time_id int NOT NULL,
report_period int NOT NULL,
id int NOT NULL,
cashflow_value double(16,2),
PRIMARY KEY (company_id,time_id,report_period,id),
FOREIGN KEY (id) REFERENCES CASHFLOW(id)
);