INSERT INTO USERINFORMATION (username, password) VALUES ("arun", "arun");

INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("CurrentRatio", 1);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("QuickRatio", 2);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("StockTurnoverRatio", 3);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("NetProfitMargin", 4);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("EBITMargins", 5);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("PERatio", 6);
INSERT INTO SHAREKEYWORDS (key_words) VALUES (">");
INSERT INTO SHAREKEYWORDS (key_words) VALUES ("<");
INSERT INTO SHAREKEYWORDS (key_words) VALUES ("=");
INSERT INTO SHAREKEYWORDS (key_words) VALUES ("<=");
INSERT INTO SHAREKEYWORDS (key_words) VALUES (">=");
INSERT INTO SHAREKEYWORDS (key_words) VALUES ("AND");
INSERT INTO SHAREKEYWORDS (key_words) VALUES ("OR");

INSERT INTO COMPANYINFORMATION (company_id, accord_id, bse_id, nse_id, company_name, bse_listed, nse_listed, group_name, market_cap) VALUES
(100325, 100325, 500325,"RIL","Reliance Industries Limited", 1, 1, "Crude Oil", "Large Cap");

INSERT INTO PERIOD (id, name) VALUES (1, "Daily");
INSERT INTO PERIOD (id, name) VALUES (2, "Week");
INSERT INTO PERIOD (id, name) VALUES (3, "Month");
INSERT INTO PERIOD (id, name) VALUES (4, "Quarter");
INSERT INTO PERIOD (id, name) VALUES (5, "YTD");

INSERT INTO RATIOS (
id, name, formula) VALUES (1, "Current Ratio","SELECT (a.balancesheet_value / b.balancesheet_value) as ratio FROM ( SELECT balancesheet_value FROM BALANCESHEETVALUES where company_id='$ID' and report_period='$PER' and balancesheet_id=492) a, ( SELECT balancesheet_value FROM BALANCESHEETVALUES where company_id='$ID' and report_period='$PER' and balancesheet_id=241) b;");
INSERT INTO RATIOS (
id, name, formula) VALUES (2, "Quick Ratio","SELECT ((a.balancesheet_value - b.balancesheet_value) / c.balancesheet_value) as ratio FROM ( SELECT balancesheet_value FROM BALANCESHEETVALUES where company_id='$ID' and report_period='$PER' and balancesheet_id=492) a, ( SELECT balancesheet_value FROM BALANCESHEETVALUES where company_id='$ID' and report_period='$PER' and balancesheet_id=419) b, ( SELECT balancesheet_value FROM BALANCESHEETVALUES where company_id='$ID' and report_period='$PER' and balancesheet_id=241) c;");
INSERT INTO RATIOS (
id, name, formula) VALUES (3, "Stock Turnover Ratio","");
INSERT INTO RATIOS (
id, name, formula) VALUES (4, "Net Profit Margin","");
INSERT INTO RATIOS (
id, name, formula) VALUES (5, "EBIT Margins","");
INSERT INTO RATIOS (
id, name, formula) VALUES (6, "PE Ratio","");


INSERT INTO RATIOVALUES (company_id, time_id, report_period, ratio_id, ratio_value) 
VALUES
(100325,5,201503,1,1.27);
INSERT INTO RATIOVALUES (company_id, time_id, report_period, ratio_id, ratio_value) 
VALUES
(100325,5,201503,2,0.87);
