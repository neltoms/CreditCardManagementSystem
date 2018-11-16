package model;
import java.io.IOException;
import java.sql.SQLException;

import dao.*;
import resources.Queries;

public class TransactionDao extends DbCon {
	
	public Transaction getTotalByType (String type) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {
		
		openCon();
		ps = con.prepareStatement(Queries.select1);
		ps.setString(1, type);
		rs = ps.executeQuery();
		Transaction t = new Transaction();
		
		if(rs.next()) {
           
           t.setValue(rs.getInt(1));
           t.setCount(rs.getInt(2));
           
         return t;

		}
			return null;

	}
}
