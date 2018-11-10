package resources;

public class Queries {

	public static String select = "SELECT * FROM customers WHERE creditLimit > ? and addressLine2 != ? ";
	
	public static String insert = "INSERT INTO CDW_SAPP_CUSTOMER VALUES ('Jaava', 'Liisa', 'Nantis', 123456780, '2001200220032002','2314', 'Valentine','Bronx','New York','USA',10458,'2038094299','jaava.nantis@gmail.com','2017-07-23')";
	
	public static String update = "UPDATE customers SET country = ? WHERE customerNumber = ?";

	public static String create = "CREATE TABLE customer_detail (\r\n" +
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
