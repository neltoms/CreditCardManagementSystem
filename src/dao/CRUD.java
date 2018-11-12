package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import resources.Queries;

public class CRUD extends DbCon {
	
	public static String columnName = null;
	public static String value = null;
	public static int ssn;
	
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
	
	public void selectTrans1() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the zip code: ");
		int zip = sc.nextInt();
		System.out.println("Please enter the year in question: ");
		int year = sc.nextInt();
		System.out.println("Please enter the month in question: ");
		int month = sc.nextInt();
			
		openCon();
		try {
		ps = con.prepareStatement(Queries.select1);
		ps.setInt(1, zip);
		ps.setInt(2, year);
		ps.setInt(3, month);

		rs = ps.executeQuery();
		System.out.println("hello");
	
		while(rs.next()) {
		
			int wssn = rs.getInt("ssn");
			int wyear = rs.getInt("year");
			int wmonth = rs.getInt("month");
			int wzip = rs.getInt("zip_code");
			String wfname = rs.getString("first name");
			String wlname = rs.getString("last name");
			
			//Display values
			System.out.print(wfname + " " + wlname + " " + wssn + " " + wzip + " " + wyear + " " + wmonth + "\r\n" );
		} 
				
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();
			System.out.print("Query Complete!");
		}
		
	}
	
	
	public void selectTrans2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the type of transacton you would like to see: \r\n"
				+ "1. Bills \r\n"
				+ "2. Healthcare \r\n"
				+ "3. Test \r\n"
				+ "4. Education \r\n"
				+ "5. Entertainment \r\n"
				+ "6. Gas \r\n"
				+ "7. Grocery"
				+ " ");
		int response = sc.nextInt();
		openCon();
		
		try {
		ps = con.prepareStatement(Queries.select2);
		switch(response) {
		case 1:
			ps.setString(1, "Bills");
			
			break;
		
		case 2:
			ps.setString(1, "Healthcare");
			
			break;
		
		case 3:
			ps.setString(1, "Test");
			
			break;
		
		case 4:
			ps.setString(1, "Education");
	
			break;
		
		case 5:
			ps.setString(1, "Entertainment");
			
			break;
		
		case 6:
			ps.setString(1, "Gas");
			
			break;
		
		case 7:
			ps.setString(1, "Grocery");
			
			break;
		
		default:
			System.out.println("Sorry, incorrect number! Try again!");
			
		}
		
		rs = ps.executeQuery();

	
		while(rs.next()) {
		
			String type = rs.getString("Transaction Type");
			String totVal = rs.getString("Total Value");
			String amtOfTrans = rs.getString("# of Transactions");
			
			//Display values
			System.out.print(type + " " + totVal + " " + amtOfTrans + "\r\n" );

		} 
		
		
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();
			System.out.print("Query Complete!");
		} 
	}
	
	public void selectTrans3() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		Scanner sc = new Scanner(System.in);
		openCon();
		System.out.println("Here is a list of the available states: ");
		this.selectStates();
		System.out.println("\n\nPlease enter the state of the branch you'd like to see: \n");
		String state = sc.next().toUpperCase();
			
		
		try {
		ps = con.prepareStatement(Queries.select3);
		ps.setString(1, state);

		rs = ps.executeQuery();
	
		while(rs.next()) {
			
			String wstate = rs.getString("state");
			int branchCode = rs.getInt("branch code");
			int totVal = rs.getInt("total value");
			int amtOfTrans = rs.getInt("# of Transactions");
			
			//Display values
			System.out.print(wstate + " " + branchCode + " " + totVal + " " + amtOfTrans + "\r\n" );
		} 
				
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();
			System.out.print("Query Complete!");
		}
		
	}
	
	public void selectTrans12() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the customer's SSN : ");
		int ssn = sc.nextInt();
			
		openCon();
		try {
		ps = con.prepareStatement(Queries.select12);
		ps.setInt(1, ssn);

		rs = ps.executeQuery();
	
		while(rs.next()) {
			
			String fname = rs.getString("First Name");
			String mname = rs.getString("Middle Name");
			String lname = rs.getString("Last Name");
			String ccn = rs.getString("ccn");
			String apt = rs.getString("apt");
			String street = rs.getString("street");
			String city = rs.getString("city");
			String state = rs.getString("state");
			String country = rs.getString("country");
			int zip = rs.getInt("zip code");
			int phone = rs.getInt("phone");
			String email = rs.getString("e-mail");
			Timestamp lUpdated = rs.getTimestamp("last updated");
			
			
			//Display values
			System.out.print(lname + " " + mname + " " + fname + " " + ccn + " " 
			+ apt + " " + street + " " + city  + " " + state + " " + country + " " + 
			zip + phone + " " + email  + " " + lUpdated +  "\r\n" );
		} 
				
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();
			System.out.print("Query Complete!");
		}
		
	}
	
	
		
	public void selectStates() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		st = con.createStatement();
		rs = st.executeQuery(Queries.selectStates);
		while(rs.next()) {
			String state = rs.getString("state");
			System.out.print(state + ", ");
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
	
	public void update() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		openCon();
		
		try {
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter ssn of customer you would like to update?");
			ssn = sc.nextInt();
			System.out.println("Which column would you like to update?");
			columnName = sc.next(); // ******* need to allow spaces for address *******
			System.out.println("Enter new value: ");
			value = sc.next();
			
			st = con.createStatement();
			st.executeUpdate(Queries.update);
			System.out.println("Update complete!");
			
			st = con.createStatement();
			rs = st.executeQuery(Queries.result);
			
			while(rs.next()) {
				
				String fname = rs.getString("first_name");
				String mname = rs.getString("Middle_Name");
				String lname = rs.getString("Last_Name");
				String ccn = rs.getString("credit_card_no");
				String apt = rs.getString("apt_no");
				String street = rs.getString("street_name");
				String city = rs.getString("cust_city");
				String state = rs.getString("cust_state");
				String country = rs.getString("cust_country");
				int zip = rs.getInt("cust_zip");
				int phone = rs.getInt("cust_phone");
				String email = rs.getString("cust_email");
				Timestamp lUpdated = rs.getTimestamp("last_updated");
				
				
				//Display values
				System.out.print(lname + " " + mname + " " + fname + " " + ccn + " " 
				+ apt + " " + street + " " + city  + " " + state + " " + country + " " + 
				zip + " " + phone + " " + email  + " " + lUpdated +  "\r\n" );
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeCon();
		}
	}
	
	

}