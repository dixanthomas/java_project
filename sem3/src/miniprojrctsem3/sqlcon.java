package miniprojrctsem3;
import java.sql.*;

public class sqlcon {
	public static Connection connect() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:dixan","hr","Dixan#96");
		}
		catch(Exception ex) {System.out.println("ERROR : "+ex);}
		return con;
	}
	
	
}
