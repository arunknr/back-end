INSERT INTO PROFITLOSS (id, level_indicator, value_required, bold_required, name) VALUES ('1',1,0,1,'EQUITY AND LIABILITIES');
INSERT INTO PROFITLOSS (id, level_indicator, value_required, bold_required, name) VALUES ('2',2,0,0,'Shareholder\'s Funds');
INSERT INTO PROFITLOSS (id, level_indicator, value_required, bold_required, name) VALUES ('3',3,1,0,'Share Capital');
INSERT INTO PROFITLOSS (id, level_indicator, value_required, bold_required, name) VALUES ('4',4,0,0,'Equity - Authorised');
INSERT INTO PROFITLOSS (id, level_indicator, value_required, bold_required, name) VALUES ('5',4,0,0,'Equity - Issued');

INSERT INTO PROFITLOSSVALUES (company_id, time_id, report_period, id, profitloss_value)
VALUES
(100325,5,201503,3,3236);
INSERT INTO PROFITLOSSVALUES (company_id, time_id, report_period, id, profitloss_value)
VALUES
(100325,5,201503,4,5000);
INSERT INTO PROFITLOSSVALUES (company_id, time_id, report_period, id, profitloss_value)
VALUES
(100325,5,201503,5,3236);