package model;
import java.io.IOException;
import java.sql.SQLException;

import dao.*;
import resources.Queries;

public class TransactionDao extends DbCon {
	
	public Transaction getTotalByType (String type) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		openCon();
		ps = con.prepareStatement(Queries.select1);
		ps.setString(1, type);
		rs = ps.executeQuery();
		Transaction t = new Transaction();
		
		if(rs.next()) {
           
           //String transaction_type = rs.getString(1);
           t.setValue(rs.getInt(1));
           t.setCount(rs.getInt(2));
           //System.out.println(" Sum of values of all Transaction " + number);
           //System.out.println("Total Number of Transaction: "+ transaction_type);
         return t;

		}
			return null;

	}
}
