package catering_management.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import catering_management.model.EventForm;
import catering_management.model.User;
import catering_management.util.SQLConnection;

public class EventFormDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	static Connection conn = SQLConnection.getDBConnection();  

	public static void SaveEvent(EventForm event) {
		Statement stmt = null;   
//		Connection conn = SQLConnection.getDBConnection();  
		//event.setUid("1001659497");
		String register = "INSERT INTO `catering_management`.`events` ( `eventname`, `eventdate`, `starttime`, `duration`, `hallname`, `estattendes`, `foodtype`, `meal`, `mealformality`, `drinktype`, `entertainmentitems`, `eventstatus`, `estimatedcost`, `iduser`, `creditcardnumber`, `expdate`, `pin`, `lastname`, `firstname`)";
		register += " VALUES ('"  
				+ event.getEvent_name()+ "','"
				+ event.getStart_date() + "','"
				+ event.getStart_time() + "','"
				+ event.getDuration()  + "','"
				+ event.getHall_name() + "','"
				+ event.getEstimated_attendees() + "','"
				+ event.getFood_type()+ "','"
				+ event.getMeal() + "','" 
				+ event.getMeal_formality() + "','"
				+ event.getDrink_type() + "','"
				+ event.getEntertainment_items() + "','"		
				+ event.getEventStatus() + "','"
				+ event.getCost()+ "','"	
				+ event.getUid()+"','"//"(SELECT uta_id FROM  `catering_management`.`systemuser WHERE uta_id=`" + event.getUid()+"')"+"','"	
				+ event.getCreditcard_number() + "','"	
				+ event.getCreditcard_expiry() + "','"	
				+ event.getCreditcard_pin() + "','"	
				+ event.getLast_name() + "','"	
				+ event.getFirst_name() + "')";

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
	
	
	public static void updateEvent(String old_eventname, EventForm event) {
		Statement stmt = null;   

		String register = "UPDATE catering_management.events SET eventname=\""+ event.getEvent_name() +"\" , eventdate=\""+ event.getStart_date()+"\" , starttime=\""+event.getStart_time()+"\", duration=\""+event.getDuration()+"\", hallname=\""+event.getHall_name()+"\", estattendes=\""+event.getEstimated_attendees()+"\", foodtype=\""+event.getFood_type()+"\", meal=\""+event.getMeal()+"\", mealformality=\""+event.getMeal_formality()+"\", drinktype=\""+event.getDrink_type()+"\", entertainmentitems=\""+event.getEntertainment_items()+"\", lastname=\""+event.getLast_name()+"\", firstname=\""+event.getFirst_name()+"\", assigned_lname=\""+event.getAssigned_lname()+"\", assigned_fname=\""+event.getAssigned_fname()+"\" WHERE eventname=\""+old_eventname+"\"";
		System.out.println("Update query is "+register);

		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate(register);
			conn.commit();		
		} catch (SQLException e) {
		       System.err.println(e);
		}   
	}
	
	
	public static void updateEventByUser(String old_eventname, EventForm event) {
		Statement stmt = null;   

		String register = "UPDATE catering_management.events SET eventname=\""+ event.getEvent_name() +"\" , eventdate=\""+ event.getStart_date()+"\" , starttime=\""+event.getStart_time()+"\", duration=\""+event.getDuration()+"\", hallname=\""+event.getHall_name()+"\", estattendes=\""+event.getEstimated_attendees()+"\", foodtype=\""+event.getFood_type()+"\", meal=\""+event.getMeal()+"\", mealformality=\""+event.getMeal_formality()+"\", drinktype=\""+event.getDrink_type()+"\", entertainmentitems=\""+event.getEntertainment_items()+"\", lastname=\""+event.getLast_name()+"\", firstname=\""+event.getFirst_name()+"\" WHERE eventname=\""+old_eventname+"\"";
		System.out.println("UpdateUser query is "+register);


		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate(register);
			conn.commit();		
		} catch (SQLException e) {
		       System.err.println(e);
		}   
	}
	
	private static ArrayList<EventForm> ReturnMatchingEventsList(String queryString) {
		System.out.println("queryString = "+queryString);
		ArrayList<EventForm> eventsListInDB = new ArrayList<EventForm>();
		int count=0;

		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet eventsList = stmt.executeQuery(queryString);
			while (eventsList.next()) {
				count++;
				EventForm events = new EventForm();
				System.out.println("phone = "+eventsList.getString("eventname"));
				

				
				events.setUid(eventsList.getString("iduser"));
				events.setEvent_name(eventsList.getString("eventname"));
				events.setStart_date(eventsList.getString("eventdate"));
				events.setStart_time(eventsList.getString("starttime"));
				events.setDuration(eventsList.getString("duration"));
				events.setHall_name(eventsList.getString("hallname"));
				events.setLast_name(eventsList.getString("lastname"));
				events.setFirst_name(eventsList.getString("firstname"));
				events.setEstimated_attendees(eventsList.getString("estattendes"));
				//events.setCost();(eventsList.getString("estimatedcost"));
				events.setFood_type(eventsList.getString("foodtype"));
				events.setMeal(eventsList.getString("meal"));
				events.setMeal_formality(eventsList.getString("mealformality"));
				events.setDrink_type(eventsList.getString("drinktype"));
				events.setEntertainment_items(eventsList.getString("entertainmentitems"));
				events.setCreditcard_number(eventsList.getString("creditcardnumber"));
				events.setCreditcard_expiry(eventsList.getString("expdate"));
				events.setCreditcard_pin(eventsList.getString("pin"));
				events.setEventStatus(eventsList.getString("eventstatus"));
				events.setAssigned_lname(eventsList.getString("assigned_lname"));
				events.setAssigned_fname(eventsList.getString("assigned_fname"));
				
				
						


								
				eventsListInDB.add(events);
			}
			System.out.println(count);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return eventsListInDB;
	}
	
	
	// search event
	public static ArrayList<EventForm> getEventsByDate(String date) {
		System.out.println("inside getEventsByDate function in EventFormDAO");
		return ReturnMatchingEventsList(
				"SELECT * FROM catering_management.events where eventdate = \""+date+"\""); // Change
	}
	
	public static ArrayList<EventForm> getEventsBetweenDates(String start_date, String end_date) {
		System.out.println("inside getEventsBetweenDates function in EventFormDAO");
		return ReturnMatchingEventsList(
				"SELECT * FROM catering_management.events WHERE eventdate >= '"+start_date+"' AND eventdate <= '"+end_date+"'"); // Change
	}
	
	public static ArrayList<User> getstaff(String lastname,String firstname) {
		System.out.println("inside UserDAO function searchstaff");
		return ReturnMatchingUsersList("SELECT * from catering_management.systemuser WHERE lastname = '"+lastname+"' AND firstname = '"+firstname+"' AND role=\"Caterer_Staff\""); // Change
	}
	
	
	
	
	
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

	
	
	
	
	public static void assignstaff(String ename,String lname,String fname) {
		Statement stmt = null;   
//		Connection conn = SQLConnection.getDBConnection();  
		//event.setUid("1001659497");
		String register = "UPDATE catering_management.events as e set e.assigned_lname=\""+fname+"\" ,e.assigned_fname=\""+lname+"\" WHERE e.eventname=\""+ename+"\"";

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