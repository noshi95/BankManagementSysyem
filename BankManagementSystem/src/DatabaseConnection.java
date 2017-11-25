/**
 * this class is for conneting database
 * the driver manager path is declared
 */

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DatabaseConnection
{
	
		Connection conn = null;
		public static Connection dbConnector()
		{
		try
		{

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/usn_bank","root",null);
			return conn;
	
		}
		
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Cannot connect to database.");
			return null;
		}
		
	}
}
