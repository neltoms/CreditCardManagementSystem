package dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public abstract class DbCon {
	
	protected Statement st = null;
	protected ResultSet rs = null;
	protected PreparedStatement ps = null;
	protected static Connection con = null;
	

	public static void openCon() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		FileReader f = new FileReader("db.properties");
		Properties p = new Properties();
		
		p.load(f);
		
		System.out.println("Connecting to Database....");
		try{
		con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("usr"), p.getProperty("pwd"));
		System.out.println("Database connection established");
	} catch(SQLException e){
		System.out.println(e.getStackTrace());
	}
		
	}
	
	public void closeCon() {
		
		try {
			
			con.close();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
	}
}




