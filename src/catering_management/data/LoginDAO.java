package catering_management.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import catering_management.model.Login;
import catering_management.util.SQLConnection;

public class LoginDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	static Connection conn = SQLConnection.getDBConnection();  

	public static String[] UserLogin(Login login) {
		Statement stmt = null;   

		
		String role = "";
		String username = login.getUsername();
		String password = login.getPassword();

		
        String[] ans = new String[10]; 

		String login_query = "SELECT * FROM catering_management.systemuser WHERE username='"+username+"' and password='"+password+"'";					

		
//		String register = "SELECT * FROM mac_facility.all_users";
		try {
//			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
//			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(login_query);
			conn.commit();		
			System.out.println("\n\n\n");
			if(results.next()) {

//	              System.out.println("login successful");
	              ans[0] = results.getString(6);
	              ans[1] = results.getString(1);
	              ans[2]= results.getString(4);
	              ans[3]= results.getString(5);
	  			  System.out.println(ans[6]);
	        }
			else {
	              System.out.println("login failed");
			}
			System.out.println("Connection Successful");
		} catch (SQLException e) {
		       System.err.println(e);
		}
		return ans;   
		
	}
	
}