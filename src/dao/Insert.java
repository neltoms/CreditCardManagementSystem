package dao;

import java.io.IOException;
import java.sql.SQLException;
import resources.*;

public class Insert extends DbCon {
	
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

}