package catering_management.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import catering_management.model.EventForm;
import catering_management.model.Registration;
import catering_management.model.User;
import catering_management.util.SQLConnection;

public class UserDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();

	private static ArrayList<User> ReturnMatchingUsersList(String queryString) {
		System.out.println("queryString = "+queryString);
		ArrayList<User> userListInDB = new ArrayList<User>();
		int count=0;

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet userList = stmt.executeQuery(queryString);
			while (userList.next()) {
				count++;
				User user = new User();
				//System.out.println("phone = "+userList.getString("phone"));
				
				user.setUsername(userList.getString("username"));
				user.setPassword(userList.getString("password"));
				user.setLastName(userList.getString("lastname"));
				user.setFirstName(userList.getString("firstname"));
				user.setPhone(userList.getString("phone"));
				user.setEmail(userList.getString("email"));
				user.setRole(userList.getString("role"));
				user.setUtaId(userList.getString("uta_id"));
				user.setStreet_Number(userList.getString("streetnumber"));
				user.setStreet_Name(userList.getString("streetname"));
				user.setCity(userList.getString("city"));
				user.setState(userList.getString("state"));
				user.setZipCode(userList.getString("zip"));
				System.out.println("phone = "+user.getPhone());
								
				userListInDB.add(user);
			}
			System.out.println(count);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return userListInDB;
	}
	
	private static ArrayList<Registration> ReturnMatchingRegistrationList(String queryString) {
		System.out.println("queryString = "+queryString);
		ArrayList<Registration> RegListInDB = new ArrayList<Registration>();
		int count=0;

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			ResultSet userList = stmt.executeQuery(queryString);
			while (userList.next()) {
				count++;
				Registration user= new Registration();
				//System.out.println("phone = "+userList.getString("phone"));
				
				user.setUsername(userList.getString("username"));
				user.setPassword(userList.getString("password"));
				user.setLastName(userList.getString("lastname"));
				user.setFirstName(userList.getString("firstname"));
				user.setPhone(userList.getString("phone"));
				user.setEmail(userList.getString("email"));
				user.setRole(userList.getString("role"));
				user.setUtaId(userList.getString("uta_id"));
				user.setStreet_Number(userList.getString("streetnumber"));
				user.setStreet_Name(userList.getString("streetname"));
				user.setCity(userList.getString("city"));
				user.setState(userList.getString("state"));
				user.setZipCode(userList.getString("zip"));
				System.out.println("phone = "+user.getPhone());
								
			RegListInDB.add(user);
			}
			System.out.println(count);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return RegListInDB;
	}
	private static void DeleteUserfromDB(String queryString) {
		System.out.println("queryString = "+queryString);

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(queryString);
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println(e);
		}
	}


	// search user
	public static ArrayList<User> searchUsers(String username) {
		System.out.println("inside UserDAO function searchUsers");
		return ReturnMatchingUsersList(
				" SELECT * from catering_management.systemuser WHERE lastname LIKE '%" + username + "%' ORDER BY lastname,firstname,role"); // Change
	}
	public static ArrayList<User> getstaff(String lastname,String firstname) {
		System.out.println("inside UserDAO function searchstaff");
		return ReturnMatchingUsersList("SELECT * from catering_management.systemuser WHERE lastname = '"+lastname+"' AND firstname = '"+firstname+"' AND role=\"Caterer_Staff\""); // Change
	}
	public static void deleteUser(String username) {
		System.out.println("inside UserDAO function deleteUser");
		DeleteUserfromDB(
				"DELETE FROM `catering_management`.`systemuser` WHERE `username`= '"+username+"' "  ); 
	}
	public static ArrayList<User> getuser(String username) {
		System.out.println("inside UserDAO function searchstaff");
		return ReturnMatchingUsersList("SELECT * from catering_management.systemuser WHERE username = '"+username+"' "); 
	}
	public static ArrayList<Registration> getreg(String username) {
		System.out.println("inside UserDAO function searchstaff");
		return ReturnMatchingRegistrationList("SELECT * from catering_management.systemuser WHERE username = '"+username+"' "); 
	}	
	

	public static Boolean userExists(String username) {     
		Connection conn = null;  
		boolean result = false;
		
		conn = SQLConnection.getDBConnection();  
		
		try {
			java.sql.PreparedStatement st = conn.prepareStatement("SELECT * from catering_management.systemuser WHERE username = ?");
			
			st.setString(1, username);
			
			ResultSet userList = st.executeQuery();
			
			if(userList.next()) {
				result = true;
			}else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static void ModifyRoleinTable (String queryString, String username, String role) throws SQLException {
		System.out.println(queryString);
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();
		
		java.sql.PreparedStatement prep_stmt = conn.prepareStatement(queryString);
		prep_stmt.setString(1, role);
		prep_stmt.setString(2, username);
		  
		try {
			stmt = conn.createStatement();
			
			int res = prep_stmt.executeUpdate();	
			System.out.println(res);
			conn.commit(); 
		} catch (SQLException e) {}
	}

	public static void changeroleUser(String username, String role) throws SQLException{
		System.out.println("in modifyUser");
		System.out.println(username);
		System.out.println(role);
//		String prep_query = "update mac_facility.all_users set role = ? where username = ?";
		
		ModifyRoleinTable("UPDATE catering_management.systemuser set role = ? WHERE username = ?",username,role);
	}


	// //determine if companyID is unique
	// public static Boolean CompanyIDunique(String idComp) {
	// return (ReturnMatchingCompaniesList(" SELECT * from COMPANY WHERE IDCOMPANY =
	// '"+idComp+"' ORDER BY company_name").isEmpty());
	// }
	// //search company with company ID
	// public static ArrayList<Company> searchCompany (String idComp) {
	// return ReturnMatchingCompaniesList(" SELECT * from COMPANY WHERE IDCOMPANY =
	// '"+idComp+"' ORDER BY company_name");
	// }
}