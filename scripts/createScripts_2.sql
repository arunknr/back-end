INSERT INTO USERINFORMATION (user_name, password) VALUES ("arun", "arun");

INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("Current Ratio", 1);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("Quick Ratio", 2);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("Stock Turnover Ratio", 3);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("Net Profit Margin", 4);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("EBIT Margins", 5);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("PE Ratio", 6);
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES (">", "");
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("<", "");
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("=", "");
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("<=", "");
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES (">=", "");
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("AND", "");
INSERT INTO SHAREKEYWORDS (key_words, ratio_id) VALUES ("OR", "");

INSERT INTO COMPANYINFORMATION (accord_id, shian_id, bse_id, nse_id, company_name, bse_listed, nse_listed, group_name, market_cap) VALUES
(100325, 100325, 500325,"RIL","Reliance Industries Limited", "Y", "Y", "Crude Oil", "Large Cap");

INSERT INTO PERIOD (time_id, time_value) VALUES (1, "Daily");
INSERT INTO PERIOD (time_id, time_value) VALUES (2, "Week");
INSERT INTO PERIOD (time_id, time_value) VALUES (3, "Month");
INSERT INTO PERIOD (time_id, time_value) VALUES (4, "Quarter");
INSERT INTO PERIOD (time_id, time_value) VALUES (5, "YTD");

INSERT INTO RATIOS (
ratio_id, ratio_name, attribute1, attribute2, attribute3, attribute4, attribute5, attribute6, attribute7,
attribute8, attribute9, attribute10) VALUES (1, "Current Ratio","T_BALANCESHEET","Total_Current_Assets","O_DIV","T_BALANCESHEET","Total_Current_Liabilities","","","","","");
INSERT INTO RATIOS (
ratio_id, ratio_name, attribute1, attribute2, attribute3, attribute4, attribute5, attribute6, attribute7,
attribute8, attribute9, attribute10) VALUES (2, "Quick Ratio","O_OPENBRACKET","T_BALANCESHEET","Total_Current_Assets","O_MINUS","T_BALANCESHEET","Inventories","O_CLOSEBRACKET","O_DIV","T_BALANCESHEET","Total_Current_Liabilities");
INSERT INTO RATIOS (
ratio_id, ratio_name, attribute1, attribute2, attribute3, attribute4, attribute5, attribute6, attribute7,
attribute8, attribute9, attribute10) VALUES (3, "Stock Turnover Ratio","","","","","","","","","","");
INSERT INTO RATIOS (
ratio_id, ratio_name, attribute1, attribute2, attribute3, attribute4, attribute5, attribute6, attribute7,
attribute8, attribute9, attribute10) VALUES (4, "Net Profit Margin","","","","","","","","","","");
INSERT INTO RATIOS (
ratio_id, ratio_name, attribute1, attribute2, attribute3, attribute4, attribute5, attribute6, attribute7,
attribute8, attribute9, attribute10) VALUES (5, "EBIT Margins","","","","","","","","","","");
INSERT INTO RATIOS (
ratio_id, ratio_name, attribute1, attribute2, attribute3, attribute4, attribute5, attribute6, attribute7,
attribute8, attribute9, attribute10) VALUES (6, "PE Ratio","","","","","","","","","","");