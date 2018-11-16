package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import resources.Queries;

public class CRUD extends DbCon {
	
	public static String columnName;
	public static String value;
	public static int ssn;
	
	public void create() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InterruptedException {
		
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
	
	public void selectTrans1() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		int zip = 0;
		int year = 0;
		int month = 0;
		
		while(true) {
			
			try {
				System.out.println("Please enter the 5-digit zip code: ");
				zip = sc.nextInt();
				String strZip = Integer.toString(zip);
				if(!(strZip.matches("[0-9]{5}") || strZip.matches("[0-9]{4}"))) {
					JOptionPane.showMessageDialog(null, "You must enter a number between 4 and 5 digits");
					continue;
				} break;
				
				} catch (InputMismatchException e) {
					JOptionPane.showMessageDialog(null, "You must enter numbers only...");
					sc.next();
					continue;
				}
		}
		
		openCon();
		try {
		ps = con.prepareStatement(Queries.select1);
		ps.setInt(1, zip);
		ps.setInt(2, year);
		ps.setInt(3, month);

		rs = ps.executeQuery();
	
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
			System.out.print("Query Complete! \n");
		}
		
	}
	
	
	public void selectTrans2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		int response;
		
		while(true) {
			
			try {
				System.out.println("Please enter the type of transacton you would like to see: \r\n"
						+ "1. Bills \r\n"
						+ "2. Healthcare \r\n"
						+ "3. Test \r\n"
						+ "4. Education \r\n"
						+ "5. Entertainment \r\n"
						+ "6. Gas \r\n"
						+ "7. Grocery");
				
				response = sc.nextInt();
				String strRes = Integer.toString(response);
				if(!(strRes.matches("[1-7]{1}"))) {
					JOptionPane.showMessageDialog(null, "You must enter only one number between 1 and 7");
					continue;
				} break;
				
				} catch (InputMismatchException e) {
					JOptionPane.showMessageDialog(null, "You must enter numbers only...");
					sc.next();
					continue;
				}
		}
		
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
			System.out.print("Query Complete!\n\n");
		} 
	}
	
		public void selectTrans3() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		String[] entry = new String[1]; 
		String[] state = {"MN", "IL", "NY", "FL", "PA", "NJ", "CT", "OH", "MI", "KY", "MD", "WA",
				"CA", "TX", "NC", "VA", "GA", "MT", "AR", "MS", "WI", "IN", "SC", "MA", "IA", "AL"};
		boolean var = true;
		
		
		while(var) {

				openCon();
				System.out.println("Here is a list of the available states: \n");
				this.selectStates();
				System.out.println("\n\nPlease enter the state of the branch you'd like to see: \n");
				entry[0] = sc.nextLine().toUpperCase();
				for(int i = 0; i < state.length; i++) {
					if(entry[0].equals(state[i])) {
						var=false;
						break;
					}		
				} 
				if (var == true) {
				JOptionPane.showMessageDialog(null, "You must enter a valid state");
				continue;	
				
				}
		}
		
		
		try {
		ps = con.prepareStatement(Queries.select3);
		ps.setString(1, entry[0]);

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
			System.out.print("\nQuery Complete!\n\n");
		}
		
	}
	
	public void selectTrans21() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		int ssn;
		
		while(true) {
			try {
				System.out.println("\nPlease enter the customer's SSN: ");
				ssn = sc.nextInt();
				String ssnStr = Integer.toString(ssn);
		
				if(!(ssnStr.matches("[0-9]{9}"))){
					JOptionPane.showMessageDialog(null, "A ssn must be 9 digits.\n");
					continue;
				} break;
				
			} catch(InputMismatchException e) {
				JOptionPane.showMessageDialog(null, "Please enter numbers only.\n");
				sc.nextLine();
				continue;
			}
		}	
		
		
		openCon();
		try {
		ps = con.prepareStatement(Queries.select21);
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
			System.out.print("\nQuery Complete!\n\n");
		}
		
	}

	
	public void selectTrans23() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the credit card number: ");
		String ccNum = sc.next();
		System.out.println("Please enter the month: ");
		int month = sc.nextInt();
		System.out.println("Please enter the year: ");
		int year = sc.nextInt();
			
		openCon();
		try {
		ps = con.prepareStatement(Queries.select23);
		PreparedStatement ps2 = con.prepareStatement(Queries.showName);
		ps.setString(1, ccNum);
		ps.setInt(2, month);
		ps.setInt(3, year);
		ps2.setString(1, ccNum);

		rs = ps.executeQuery();
		ResultSet rs2 = ps2.executeQuery();
		
		while(rs2.next()) {
			
			String fname = rs2.getString("first name");
			String lname = rs2.getString("last name");

			
			System.out.print(fname + " " + lname + "\r\n" );
		}
		
		while(rs.next()) {
			
			int wid = rs.getInt("id");
			int wmonth = rs.getInt("Month");
			int wday = rs.getInt("Day");
			int wyear = rs.getInt("Year");
			String type = rs.getString("type");
			int transVal = rs.getInt("value");
			

			System.out.print(wid + " " + wmonth + " " + wday + " " + wyear + " " + type + " " + "$"+transVal + "\r\n" );
		} 
				
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();
			System.out.print("\nQuery Complete!\n\n");
		}
		
	}
	
	public void selectTrans24() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InterruptedException{
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the customer ssn: ");//1
		int ssNum = sc.nextInt();
		System.out.println("Please enter the beginning date in format YYYYMMDD: "); //2
		int bdate = sc.nextInt();//
		System.out.println("Please enter the ending date in format YYYYMMDD: "); //3
		int edate = sc.nextInt();//


		openCon();
		try {
		if(bdate<edate) {

		ps = con.prepareStatement(Queries.select24);
		ps.setInt(1, ssNum);
		ps.setInt(2, bdate);
		ps.setInt(3, edate);
		
		
		rs = ps.executeQuery();
		rsmd = rs.getMetaData();
		String col1 = rsmd.getColumnName(4);
		String col2 = rsmd.getColumnName(2);
		String col3 = rsmd.getColumnName(1);
		String col4 = rsmd.getColumnName(3);
		String col5 = rsmd.getColumnName(5);
		String col6 = rsmd.getColumnName(6);
		String col7 = rsmd.getColumnName(8);
		String col8 = rsmd.getColumnName(9);
		String col9 = rsmd.getColumnName(7);
		
		System.out.print("  " + col1 + "     " + col2 + "    " + col3 + "  " + col4 + " " + col5 + " " +
		" " + col6 + " " + col7 + " " + col8 + " " + col9 + "\r\n");
		
		while(rs.next()) {
			
			int wssn = rs.getInt("ssn");
			int wmonth = rs.getInt("Month");
			int wyear = rs.getInt("Year");
			int wday = rs.getInt("Day");
			String wcfname = rs.getString("firstName");
			String wclname = rs.getString("lastName");
			int transid = rs.getInt("id");
			String transtyp = rs.getString("type");
			int transval = rs.getInt("value");
			
			
			System.out.print(wssn + "   " + wmonth + "      " + wyear + "   " + wday + "    " + wcfname + "       " + 
			wclname + "       " +transid+ "          "+ transtyp+ "       " + "          $"+transval + " " + "\r\n");
		} 
		}		
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			closeCon();
			System.out.print("\nQuery Complete!\n\n");
		}
		
	}
	
	
	
	public String selectStates() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		st = con.createStatement();
		rs = st.executeQuery(Queries.selectStates);
		while(rs.next()) {
			String state = rs.getString("state");
			System.out.print(state + ", ");
		}
		return null;
		
	}
	
	public void insert() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InterruptedException {
		
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
	
	public void update() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {
		
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
