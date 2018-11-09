package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import resources.Queries;


public class Select extends DbCon {
	
	
	public void fetch() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Check customer's credit limit greater than...?");
		int num = sc.nextInt();
		System.out.println("Enter address(es) you would like to exclude?");
		String addr = sc.next();
			
		openCon();
		try {
		ps = con.prepareStatement(Queries.select);
		ps.setInt(1, num);
		ps.setString(2, addr);
		rs = ps.executeQuery();
		System.out.println("hello");
	
		while(rs.next()) {
			
			int cnum = rs.getInt("customerNumber");

			String cname = rs.getString("customerName");
			String clname = rs.getString("contactLastName");
			String cfname = rs.getString("contactFirstName");
			String phone = rs.getString("phone");
			
			//Display values
			System.out.print("customer number: " + cnum + ", Customer name: " + 
			cname + ", Contact last name: " + clname + ", Contact First name: " + 
			cfname + ", Phone " + phone + "\n" );
		} 
				
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();
		
			
		}
		
	}


}
			
	
			
			

	
