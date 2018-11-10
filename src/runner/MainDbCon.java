package runner;
import dao.*;
import model.Transaction;
import model.TransactionDao;
import resources.Queries;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainDbCon {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		
//		CRUD crud = new CRUD();
//		TransactionDao trdao = new TransactionDao();
//		CustomerRunner custrun = new CustomerRunner();
//		TransactionRunnable trrun = new TransactionRunnable();
//		
//		System.out.println("If you wish details of transaction, press 1; if you wish details of customer, press 2: ");
//		Scanner sc1 = new Scanner(System.in);
//		int response1 = sc1.nextInt();
//		
//		
//		switch(response1) {
//		// case for transactions
//		case 1: 
//			
//			Transaction tract = new Transaction();
//			sc1.nextLine();
//			System.out.println("1. View transaction by Zipcode");
//			tract.getZipcode();
//			System.out.println("2. View totals by Transaction Type");
//			tract.getType();
//			System.out.println("3. View totals by State");
//			tract.getState();
//			System.out.println("Make a choice: ");
//			Scanner sc2 = new Scanner(System.in);
//			int response2 = sc2.nextInt();
//			
//			switch(response2) {
//			case 1: 
//				
//				
//				
//				break;
//				
//			case 2: 
//				
//				
//				break;
//				
//				
//			case 3: 
//				
//				
//				break;
//		
//			
//			default: 
//			System.out.println("Invalid enter, please refresh the page");
//			}
//			
//			case 2: 
//			
//			System.out.println("1. Check existing account details of a customer");
//			tract.getCount();
//			System.out.println("2. Modify existing account details of a customer");
//			tract.setCount(count);
//			System.out.println("3. Generate mothly bill for a credit card number for a given month and year");
//			////// create a row
//			System.out.println("4. Display transactions made by a customer between two dates");
//			tract.getTransaction();
//			System.out.println("Make a choice: ");
//			
//			break;
//			
//			Scanner sc3 = new Scanner(System.in);
//			int response3 = sc3.nextInt();
//			
//			switch(response3) {
//			case 1: 
//				
//				
//				break;
//				
//			case 2: 
//				
//				
//				break;
//				
//				
//			case 3: 
//				
//				
//				break;
//
//			case 4: 
//				
//				
//				break;
//
//				
//			default: 
//				System.out.println("Invalid enter, please refresh the page");
//
//			}
//			
//		default: 
//			System.out.println("Invalid enter, please refresh the page");
//
//			
//		}
		
		
		
			CRUD sec = new CRUD();
			sec.select();
//			
//			CRUD cre = new CRUD();
//			cre.create();
//			
//			CRUD ins = new CRUD();
//			ins.insert();
//			
//			Update upd = new Update();
//			upd.update();
			
		}
	}


