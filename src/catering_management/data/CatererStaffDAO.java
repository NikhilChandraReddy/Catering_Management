package catering_management.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import catering_management.model.EventForm;
import catering_management.util.SQLConnection;



public class CatererStaffDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	static Connection conn = SQLConnection.getDBConnection();  

	
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
				//System.out.println("phone = "+userList.getString("phone"));
				

				
				
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
	public static ArrayList<EventForm> getEvents(String date, String time, String lastname, String firstname) {
		System.out.println("inside UserDAO function searchUsers");
		return ReturnMatchingEventsList(
				"SELECT * from catering_management.events WHERE assigned_lname='"+lastname+"' AND assigned_fname='"+firstname+"'"); // Change
	}
	public static ArrayList<EventForm> getEventsforuser(String date, String time, String utaID) {
		System.out.println("inside UserDAO function searchUsers");
		return ReturnMatchingEventsList(
				"SELECT * from catering_management.events WHERE iduser='"+utaID+"'"); // Change
	}


}