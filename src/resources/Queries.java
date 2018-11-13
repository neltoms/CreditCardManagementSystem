package resources;

import dao.CRUD;

public class Queries {
	
	public static String select1 = "SELECT cu.first_name as 'First Name', cu.last_name as 'Last Name', c.cust_ssn AS ssn, c.TRANSACTION_ID AS 'Transaction ID', "
			+ "B_ZIP AS 'zip_code', "
			+ "c.DAY AS 'Day', "
			+ "c.MONTH AS 'Month', "
			+ "c.YEAR AS 'Year' "
			+ "FROM CDW_SAPP_branch "
			+ "JOIN CDW_SAPP_creditcard c ON CDW_SAPP_BRANCH.BRANCH_CODE=c.BRANCH_CODE "
			+ "join cdw_sapp_customer cu on cu.credit_card_no=c.credit_card_no "
			+ "WHERE B_ZIP= ? and c.YEAR=? and c.MONTH=? "
			+ "ORDER BY Day DESC";
	
	public static String select2 = "SELECT CDW_SAPP_CREDITCARD.TRANSACTION_TYPE AS 'Transaction Type', "
			+ "round(SUM(CDW_SAPP_CREDITCARD.TRANSACTION_VALUE),2) AS 'Total Value', "
			+ "COUNT(CDW_SAPP_CREDITCARD.TRANSACTION_TYPE) AS '# of Transactions' "
			+ "FROM CDW_SAPP_CREDITCARD "
			+ "WHERE CDW_SAPP_CREDITCARD.TRANSACTION_TYPE= ? "
			+ "GROUP BY (CDW_SAPP_CREDITCARD.TRANSACTION_TYPE) "
			+ "ORDER BY 2 DESC";
	
	public static String select3 = "SELECT CDW_SAPP_BRANCH.BRANCH_STATE AS 'State', "
			+ "CDW_SAPP_BRANCH.BRANCH_CODE AS 'Branch Code',"
			+ "SUM(CDW_SAPP_CREDITCARD.TRANSACTION_VALUE) AS 'Total Value', "
			+ "COUNT(CDW_SAPP_CREDITCARD.TRANSACTION_TYPE) AS '# of Transactions' "
			+ "FROM CDW_SAPP_CREDITCARD "
			+ "JOIN CDW_SAPP_BRANCH ON CDW_SAPP_BRANCH.BRANCH_CODE=CDW_SAPP_CREDITCARD.BRANCH_CODE "
			+ "WHERE CDW_SAPP_BRANCH.BRANCH_STATE=? "
			+ "GROUP BY CDW_SAPP_BRANCH.BRANCH_CODE "
			+ "ORDER BY 2 ASC";
	
	public static String select21 = "SELECT CDW_SAPP_CUSTOMER.LAST_NAME AS 'Last Name',\n" + 
			"CDW_SAPP_CUSTOMER.FIRST_NAME AS 'First Name', \n" + 
			"CDW_SAPP_CUSTOMER.MIDDLE_NAME AS 'Middle Name',\n" + 
			"CDW_SAPP_CUSTOMER.CREDIT_CARD_NO AS 'CCN',\n" + 
			"CDW_SAPP_CUSTOMER.APT_NO AS 'Apt',\n" + 
			"CDW_SAPP_CUSTOMER.STREET_NAME AS 'Street',\n" + 
			"CDW_SAPP_CUSTOMER.CUST_CITY AS 'City',\n" + 
			"CDW_SAPP_CUSTOMER.CUST_STATE AS 'State',\n" + 
			"CDW_SAPP_CUSTOMER.CUST_COUNTRY AS 'Country',\n" + 
			"CDW_SAPP_CUSTOMER.CUST_ZIP AS 'Zip Code',\n" + 
			"CDW_SAPP_CUSTOMER.CUST_PHONE AS 'Phone',\n" + 
			"CDW_SAPP_CUSTOMER.CUST_EMAIL AS 'E-mail',\n" + 
			"CDW_SAPP_CUSTOMER.LAST_UPDATED AS 'Last Updated'\n" + 
			"FROM CDW_SAPP_CUSTOMER \n" + 
			"WHERE SSN=? " + 
			"ORDER BY 1 ASC";
	
	public static String select23 = "select cc.transaction_id as 'id', cc.month as 'Month', cc.day as Day, cc.year as 'Year', " +
			"sum(cc.transaction_value) as 'Value', cc.transaction_type as 'Type' " +
			" from cdw_sapp_customer c \n" + 
			"join cdw_sapp_creditcard cc \n" + 
			"on c.ssn=cc.cust_ssn \n" + 
			"where cc.credit_card_no = ?  and cc.month = ? and cc.year = ? \n" + 
			"group by id, type \n" + 
			"order by id";
	
	public static String select24 = "select cc.year as year, cc.month as month, cc.day as day, c.ssn as ssn, c.first_name, c.last_name, \n" +
	        "cc.transaction_value as value, \n " + 
			"cc.transaction_id as id, cc.transaction_type as Type \n " + 
			"from cdw_sapp_creditcard cc\n " + 
			"join cdw_sapp_customer c\n " + 
			"on c.ssn = cc.cust_ssn\n " + 
			"where c.ssn = ? and (cc.month between ? and ?)\n " + 
			"and (cc.day between ? and ?)\n " + 
			"order by month, day desc";
	
	public static String showName = "SELECT c.first_name as 'First Name', c.last_name as 'Last Name'\n" + 
			"FROM cdw_sapp_customer c\n" + 
			"WHERE c.ssn = ( SELECT distinct cust_ssn FROM cdw_sapp_creditcard where credit_card_no =?)";
	
	public static String selectStates = "SELECT DISTINCT BRANCH_STATE as 'state' FROM CDW_SAPP_BRANCH ";
	
	public static String insert = "INSERT INTO CDW_SAPP_CUSTOMER VALUES ('Jaava', 'Liisa', 'Nanits', 123456780, '2001200220032002','2314', 'Valentine','Bronx','New York','USA',10458,'2038094299','jaava.nantis@gmail.com','2017-07-23')";
	
	public static String update = "UPDATE cdw_sapp_customer SET " + CRUD.columnName + " = '" + CRUD.value + "' WHERE SSN = " + CRUD.ssn;
	
	public static String result = "SELECT * FROM cdw_sapp_customer WHERE SSN = " + CRUD.ssn;
	
	
	public static String create = "DROP TABLE IF EXISTS CDW_SAPP_BRANCH; CREATE TABLE CDW_SAPP_BRANCH (\r\n" +
            "    CUST_SSN BIGINT(9),\r\n" +
            "    CUST_F_NAME VARCHAR(40),\r\n" +
            "    CUST_M_NAME VARCHAR(40),\r\n" +
            "    CUST_L_NAME VARCHAR(40),\r\n" +
            "    CUST_CC_NO VARCHAR(16),\r\n" +
            "    CUST_STREET VARCHAR(38),\r\n" +
            "    CUST_CITY VARCHAR(30),\r\n" +
            "    CUST_STATE VARCHAR(30),\r\n" +
            "    CUST_COUNTRY VARCHAR(30),\r\n" +
            "    CUST_ZIP INT(7),\r\n" +
            "    CUST_PHONE VARCHAR(8),\r\n" +
            "    CUST_EMAIL VARCHAR(40),\r\n" +
            "    LAST_UPDATED TIMESTAMP(0)\r\n" +
            ")";
	
}
