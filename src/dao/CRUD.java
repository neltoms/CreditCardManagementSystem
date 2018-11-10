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
			ps.executeUpdate();
			System.out.println("Table Created!");
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();
		}
	}	
	
	public void select() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Please enter the zip code: ");
//		int zip = sc.nextInt();
//		System.out.println("Please enter the year in question: ");
//		int year = sc.nextInt();
//		System.out.println("Please enter the month in question: ");
//		int month = sc.nextInt();
			
		openCon();
		try {
		ps = con.prepareStatement(Queries.select1);
//		ps.setInt(1, zip);
//		ps.setInt(2, year);
//		ps.setInt(3, month);

		rs = ps.executeQuery();
		System.out.println("hello");
	
		while(rs.next()) {
			
			int wyear = rs.getInt("YEAR");
			int wmonth = rs.getInt("MONTH");
			
			int wzip = rs.getInt("branchZip");
			
			//Display values
			System.out.print(wzip + " " + wyear + " " + wmonth + "\r\n" );
		} 
				
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();
			System.out.print("Query Complete!");
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