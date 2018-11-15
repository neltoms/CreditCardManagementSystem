package runner;
import dao.*;
import model.Transaction;
import model.TransactionDao;
import resources.Queries;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainDbCon {
	
	public static void transMenu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException, InterruptedException {
		System.out.println("Welcome to the Transaction Menu\n");
		System.out.println("Please select from options below\n");

		
		System.out.println("1. View transaction by Zipcode\n");
		System.out.println("2. View totals by Transaction Type\n");
		System.out.println("3. View totals by State \n");
		Scanner sc = new Scanner(System.in);
		int transMenuChoice = sc.nextInt();
		CRUD transObj = new CRUD();
		switch(transMenuChoice) {

		case 1 :transObj.selectTrans1();
			break;
		
		case 2 :transObj.selectTrans2();
			break;
		case 3 :transObj.selectTrans3();
			break;
			

		default :
			System.out.println("Invalid entry, please refresh the page\n");
		
		}
		
	}
	
	
	public static void custMenu() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
		System.out.println("Welcome to the Customer Details Menu\n");
		System.out.println("Please select from options below\n");
		System.out.println("1. Check existing account details of a customer\n");
		System.out.println("2. Modify existing account details of a customer\n");
		System.out.println("3. Generate mothly bill for a credit card number for a given month and year\n");
		System.out.println("4. Display transactions made by a customer between two dates\n");
		//System.out.println("Make a choice: ");
		
		Scanner sc = new Scanner(System.in);
		int custMenuChoice = sc.nextInt();
		

		CRUD custObj = new CRUD();
		
		
		switch(custMenuChoice) {
		
		case 1 :custObj.selectTrans21();
			break;
		
		case 2 :custObj.update();
			break;
		case 3 :custObj.selectTrans23();
			break;
			
		case 4 :custObj.selectTrans24();
			break;
			
		default :
			System.out.println("Invalid enter, please refresh the page\n");
		}
		
		
		
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InterruptedException {
		
	while(true) {	
		System.out.println("Welcome to the Credit Card Management System:\n ");
		System.out.println("What function do you want to perform today?\n\n"
				+ "1. Transaction Detail \n"
				+ "2. Customer detail\n ");
	
	Scanner sc = new Scanner(System.in);
		int funcChoice = sc.nextInt();
		switch(funcChoice) {
		
		case 1:transMenu();
			break;
		case 2:custMenu();
			break;
		default:
		System.out.println("Wrong selection or invalid input\n");
			
		}
	}
		
		
				
		}
	}


