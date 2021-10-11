package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String driver =  "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/projeto?useTimezone=true"
			+ "&serverTimezone=UTC";
	private String userAndPassword = "root";

	
	public Connection getConnection() {
	      try {
	    	  Class.forName(driver);
			  return DriverManager.getConnection(
				  url, userAndPassword, userAndPassword);
	      } catch (SQLException e) {
	          throw new RuntimeException(e);
	      } catch (ClassNotFoundException e) {

	    	  throw new RuntimeException(e);
		}
	  }
}
