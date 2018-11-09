package dao;

import java.io.IOException;
import java.sql.SQLException;

import resources.Queries;

public class Create extends DbCon {
	
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

}
