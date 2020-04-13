package catering_management.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import catering_management.model.Registration;
import catering_management.util.SQLConnection;

public class RegistrationDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	static Connection conn = SQLConnection.getDBConnection();  

	public static void Register(Registration registration) {
		Statement stmt = null;   
//		Connection conn = SQLConnection.getDBConnection();  
		String register = "INSERT INTO `catering_management`.`systemuser` (`uta_id`, `username`, `password`, `firstname`, `lastname`, `role`, `phone`, `email`, `streetnumber`, `streetname`, `city`, `state`, `zip`)";
		register += " VALUES ('"  
				+ registration.getUtaId() + "','"
				+ registration.getUsername() + "','"
				+ registration.getPassword() + "','"
				+ registration.getFirstName()  + "','"
				+ registration.getLastName() + "','"
				+ registration.getRole() + "','"
				+ registration.getPhone() + "','"
				+ registration.getEmail() + "','" 
				+ registration.getStreet_Number() + "','"
				+ registration.getStreet_Name() + "','"
				+ registration.getCity() + "','"		
				+ registration.getState() + "','"
				+ registration.getZipCode() + "')";

//		String register = "SELECT * FROM mac_facility.all_users";
		try {
//			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
//			stmt = conn.createStatement();
			stmt.executeUpdate(register);
			conn.commit();		
//			System.out.println("Connection Successful");
		} catch (SQLException e) {
		       System.err.println(e);
		}   
	}
		
///UPDATE `catering_management`.`systemuser` SET `username`=',mnam', `password`=',mn m, ', `firstname`=',m ,m,m,', `lastname`=',mn,mn,m', `phone`=',mnm,n', `email`=',mn', `streetnumber`='98', `streetname`='nb ', `city`='nmb', `state`='mnb ', `zip`='nmbmn' WHERE `username`='baalu';

	public static void updateUser(Registration registration) {
		Statement stmt = null;   
//		Connection conn = SQLConnection.getDBConnection();  
		String register = " UPDATE catering_management.systemuser SET username='"+registration.getUsername()+"', password= '"+registration.getPassword()+"', firstname='"+registration.getFirstName()+"', lastname='"+registration.getLastName()+"', phone='"+registration.getPhone()+"', email='"+registration.getEmail()+"', streetnumber='"+registration.getStreet_Number()+"', streetname='"+registration.getStreet_Name()+"', city='"+registration.getCity()+"', state='"+registration.getState()+" ', zip='"+registration.getZipCode()+"' WHERE uta_id='"+registration.getUtaId()+"';";


//		String register = "SELECT * FROM mac_facility.all_users";
		try {
//			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
//			stmt = conn.createStatement();
			stmt.executeUpdate(register);
			conn.commit();		
//			System.out.println("Connection Successful");
		} catch (SQLException e) {
		       System.err.println(e);
		}   
	}
	

}