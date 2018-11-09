package runner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import dao.*;
import model.Transaction;
import model.TransactionDao;

public class TransactionRunnable extends DbCon {
	
	public void getTotalByType() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		
		openCon();
	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    System.out.println("Please enter transaction Type:");
	    
	    String type = sc.nextLine();
	    
	    TransactionDao td = new TransactionDao();
	    
	    Transaction mytransaction = td.getTotalByType(type);
	    System.out.println(mytransaction.getCount());


	}
}