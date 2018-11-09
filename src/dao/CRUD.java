package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import resources.Queries;

public class CRUD extends DbCon {
	
	public void create() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		
		openCon();
		try {
			ps = con.prepareStatement(Queries.create);
			System.out.println(Queries.create);
			ps.execute();
			System.out.println("Table Created!");
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();
		}
	}	
	
	public void select() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
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
	
	public void insert() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		
		openCon();
		try {
			ps = con.prepareStatement(Queries.insert);
			ps.executeUpdate();
			System.out.println("Insertion complete!");
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();	
		}
		
	}	
	
	public static void update() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		openCon();
		ps = con.prepareStatement(Queries.select);
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Which country would you like to update?");
			String country = sc.next();
		
			System.out.println("For which customer number would you like to update?");
			int num = sc.nextInt();
			
			ps.setInt(2, num);
			ps.setString(1, country);
			ps.executeQuery();
			System.out.println("Update complete!");
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeCon();
		}
	}
	
	

}