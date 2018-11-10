package runner;
import dao.*;

import java.io.IOException;
import java.sql.SQLException;

public class MainDbCon {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		
		
//		Select sec = new Select();
//		sec.fetch();
		
//		Create cre = new Create();
//		cre.create();
		
		CRUD ins = new CRUD();
		ins.insert();
		
//		Update upd = new Update();
//		upd.update();
		
		

	}


}
