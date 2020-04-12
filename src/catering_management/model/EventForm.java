package catering_management.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import catering_management.data.EventFormDAO;

	
public class EventForm implements Serializable{

	private String uid = "";
	private String last_name = "";
	private String first_name = "";
	private String start_date = "";
	private String start_time = "";
	private String duration = "";
	private String hall_name = "";
	private String estimated_attendees = "";
	private String event_name = "";
	private String food_type = "";
	private String meal = "";
	private String meal_formality = "";
	private String drink_type = "";
	private String entertainment_items = "";
	private double cost = 0;
	private String creditcard_number = "";
	private String creditcard_expiry = "";
	private String creditcard_pin = "";
	private String eventStatus = "";
	private String assigned_lname="";
	private String assigned_fname="";
	
	
	 public void setEvent(String uid,String last_name, String first_name, String start_date, String start_time, String duration, String hall_name, String estimated_attendees, String event_name, String food_type, String meal, String meal_formality, String drink_type,	String entertainment_items) {
		 
		 setUid(uid);
		 setDrink_type(drink_type);
		 setStart_date(start_date);
		 setStart_time(start_time);
		 setDuration(duration);
		 setEntertainment_items(entertainment_items);
		 setEstimated_attendees(estimated_attendees);
		 setEvent_name(event_name);
		 setFirst_name(first_name);
		 setFood_type(food_type);
		 setHall_name(hall_name);
		 setLast_name(last_name);
		 setMeal(meal );
		 setMeal_formality(meal_formality);
		 
	 }
	 
	 public void setEventCC(String creditcard_number,String creditcard_expiry, String creditcard_pin){
		 
		 setCreditcard_number(creditcard_number);
		 setCreditcard_expiry(creditcard_expiry);
		 setCreditcard_pin(creditcard_pin);
		 
	 }
	
	
	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getHall_name() {
		return hall_name;
	}
	public void setHall_name(String hall_name) {
		this.hall_name = hall_name;
	}
	public String getEstimated_attendees() {
		return estimated_attendees;
	}
	public void setEstimated_attendees(String estimated_attendees) {
		this.estimated_attendees = estimated_attendees;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getFood_type() {
		return food_type;
	}
	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getMeal_formality() {
		return meal_formality;
	}
	public void setMeal_formality(String meal_formality) {
		this.meal_formality = meal_formality;
	}
	public String getDrink_type() {
		return drink_type;
	}
	public void setDrink_type(String drink_type) {
		this.drink_type = drink_type;
	}
	public String getEntertainment_items() {
		return entertainment_items;
	}
	public void setEntertainment_items(String entertainment_items) {
		this.entertainment_items = entertainment_items;
	}
	
	
	
	@SuppressWarnings("unused")
	public void validateNames(EventForm eform, EventFormErrorMsgs eferrormsgs) {
		if(eform.getAssigned_fname() != "" && eform.getAssigned_lname() != "")
		{

			eferrormsgs.setAssignedLast_nameError(validateLastName(eform.getAssigned_lname()));
			eferrormsgs.setAssignedFirst_nameError(validateFirstName(eform.getAssigned_fname()));
			if(eferrormsgs.getAssignedFirst_nameError() == "" && eferrormsgs.getAssignedLast_nameError() == "") {
				ArrayList<User> stafflist= EventFormDAO.getstaff(eform.getAssigned_lname(), eform.getAssigned_fname());
				if(stafflist.size() == 0) {
					eferrormsgs.setAssignedFirst_nameError("No such First and Last name combination Found");
					eferrormsgs.setAssignedLast_nameError("No such First and Last name combination Found");

				} 
	
			}
					}
		eferrormsgs.setLast_nameError(validateLastName(eform.getLast_name()));	

		eferrormsgs.setFirst_nameError(validateFirstName(eform.getFirst_name()));

		

		eferrormsgs.setErrorMsg();
	}
	
	
	
	private String validateLastName(String last_name) {
		String error="";
	    Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
	    Matcher matcher = pattern.matcher(last_name);
	    Pattern pattern1 = Pattern.compile("[a-zA-Z]*");
	    Matcher matcher1= pattern1.matcher(last_name);
		

		if(!matcher.matches())
			error="Last Name cannot contain special characters";
		else
//			if (action.equals("save_registration_details")) 
			if (!stringSize(last_name,3,29))
				error= "Last name length must be >2 and <30";
			else
//				if (action.equals("save_registration_details")) 
				if (Character.isLowerCase(last_name.charAt(0)))
					error= "Last Name must start with a capital letter.";
				else
					if (!matcher1.matches())
						error="Last Name must be non-numeric";								
		return error;
	}
	
	private String validateFirstName(String first_name) {
		String error="";
	    Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
	    Matcher matcher = pattern.matcher(first_name);
	    Pattern pattern1 = Pattern.compile("[a-zA-Z]*");
	    Matcher matcher1= pattern1.matcher(first_name);
		
		
		if(!matcher.matches())
			error="First Name cannot contain special characters";
		else
//			if (action.equals("save_registration_details")) 
			if (!stringSize(first_name,3,29))
				error= "First name length must be >2 and <30";
			else
//				if (action.equals("save_registration_details")) 
				if (Character.isLowerCase(first_name.charAt(0)))
					error= "First Name must start with a capital letter.";
				else
					if (!matcher1.matches())
						error="First Name must be non-numeric";
		return error;
	}
	
	
	
	
	@SuppressWarnings("unused")
	public void validateEventForm(EventForm eform, EventFormErrorMsgs eferrormsgs) {
		
		eferrormsgs.setEstimated_attendeesError(validateEstimatedAttendees(eform.estimated_attendees));
//		if (!getEstimated_attendees().equals("")){
			//eferrormsgs.setHall_nameError(validateHallName(hall_name));	
//		}
		
		eferrormsgs.setHall_nameError(validateHallName(hall_name));
		
		eferrormsgs.setDurationError(validateDuration(eform.duration));
		eferrormsgs.setEvent_nameError(validateEventName(eform.event_name));
		eferrormsgs.setErrorMsg();
	}
	
	
	private String validateDuration(String s) {
		String result = "";
		
		Hashtable<String, String> numofhours = new Hashtable<String, String>();
		numofhours.put("2 Hours", "2");
		numofhours.put("3 Hours",  "3");
		numofhours.put("4 Hours", "4" );
		numofhours.put("5 Hours", "5" );
		numofhours.put("6 Hours", "6" );
		numofhours.put("7 Hours", "7" );
		numofhours.put("8 Hours", "8" );
		
		int my_latetime = (Integer.parseInt(start_time.split(":")[0]) + Integer.parseInt(numofhours.get(s)));
		if(my_latetime>24)
			my_latetime-=24;
		int my_starttime = Integer.parseInt(start_time.split(":")[0]);

		Calendar c = Calendar.getInstance();
		
////		System.out.println(start_date);
//		
		Date d = null;
		try {
		d = new SimpleDateFormat("yyyy-MM-dd").parse(start_date);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
//		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//		System.out.println(d);
		
		
		c.setTime(d);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("day of week");
		System.out.println(dayOfWeek);
//		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		if (dayOfWeek == 7) {
			if ( my_latetime > 2 && my_starttime < 7) {
				result = "Duration cannot exceed close time";
			}	
			
		}
		else {
			if(dayOfWeek == 1) {
				if ( my_latetime > 2 && my_starttime < 12) {
					result = "Duration cannot exceed close time";
				}	
			}
			else  {
				
				if ( my_latetime > 23 || my_starttime < 7) {
					result = "Duration cannot exceed close time";
				}
			}
			
		}
		
		return result;
		
	}
	
	public void validateDateandTime(EventForm eform, EventFormErrorMsgs eferrormsgs) {
			
		eferrormsgs.setStart_dateError(validateStartDate(start_date));
		
	//	System.out.println(Integer.parseInt(start_date.split("-")[2]));
	//	System.out.println((new Date()).getDate());
		if (Integer.parseInt(start_date.split("-")[2]) == (new Date()).getDate()) {
			eferrormsgs.setStart_timeError(validateStartTime(start_time));	
		}
		eferrormsgs.setErrorMsg();
	}


	public void validateMoreDateandTime(EventForm eform, EventFormErrorMsgs eferrormsgs) {
		
		eferrormsgs.setStart_dateError(validateStartDate(start_date));
		if(eferrormsgs.getStart_dateError() == "") {
			eferrormsgs.setStart_dateError(moreDateValdiations(start_date));			
		}
	//	System.out.println(Integer.parseInt(start_date.split("-")[2]));
	//	System.out.println((new Date()).getDate());
//		if (Integer.parseInt(start_date.split("-")[2]) == (new Date()).getDate() && Integer.parseInt(start_date.split("-")[1]) == (new Date()).getMonth()  &&  Integer.parseInt(start_date.split("-")[0]) == (new Date()).getYear()) {
//			eferrormsgs.setStart_timeError(validateStartTime(start_time));	
//		}
		eferrormsgs.setErrorMsg();
	}

	
	public void validateCreditCard(EventForm eform, EventFormErrorMsgs eferrormsgs) {
		
		eferrormsgs.setCreditcard_numberError(validateCreditCardNumber(creditcard_number));
		eferrormsgs.setCreditcard_expiryError(validateCreditCardExpiry(creditcard_expiry));
		eferrormsgs.setCreditcard_pinError(validateCreditCardPin(creditcard_pin));
		eferrormsgs.setErrorMsg();
	}

	
	
	private String validateCreditCardPin(String s) {
	
		String result = "";
		if (s.length() != 4) {
			result = "Credit card pin must be 4 digits";
		}
		else if (!isTextAnInteger(s)) {
			result = "Credit card pin must be a number";
		}
		
		return result;
		
		
	}



	private String validateCreditCardExpiry(String s) {
		String result = "";
		
		
		Date dNow = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dNow);
		int dNowYear = calendar.get(Calendar.YEAR);
		int dNowMonth = calendar.get(Calendar.MONTH) + 1;
		int dNowDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		
		if (s.length() != 4) {
			result = "Credit card exp date must be 4 digits";
		}
		else if (!isTextAnInteger(s)) {
			result = "Credit card exp date must be a number";
		}
		
		return result;
	}



	private String validateCreditCardNumber(String s) {
		String result = "";
		if (s.length() != 16) {
			result = "Credit card number must be 16 digits";
		}
		else if (!isTextAnInteger(s)) {
			result = "Credit card number must be a number";
		}
		
		return result;
	}



	@SuppressWarnings("unused")
	private String validateName(String name) {
		String result="";
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(name);
		boolean b = m.find();

		if (b)
			result = "Name should not contain any special characters";
		
		if (isTextAnInteger(name))
			result="Your First Name must be non-numeric";
	 
		if (!isStringSizeBetween(name,2,30))
			result= "Your First Name must between 3 and 40 characters.";
		
		if (Character.isLowerCase(name.charAt(0)))
				result= "Your First Name must start with a capital letter.";
			
		return result;
	}
	
	
	@SuppressWarnings("unused")
	private String validateEventName(String name) {
		String result="";

		try {
			Integer.parseInt(name);
			return "Cannot be numeric";
			}
		catch(Exception e) {}
		
		if(name.equals(""))
			result="Cannot be null";
		else
			if (!isStringSizeBetween(name,2,30))
			result= "Your Event Name must between 3 and 30 characters.";
			else
				if (Character.isLowerCase(name.charAt(0)))
					result= "Your Event Name must start with a capital letter.";
				
		return result;
	}
	
	
	@SuppressWarnings("unused")
	private String validateEstimatedAttendees(String s) {
		String result="";
		int count;
		
		if( getEstimated_attendees().contentEquals(""))
		{
			return "Cannot be empty";
		}
		try {
		count = Integer.parseInt(s); 
		if (count<=0)  
			result = "Estimated Attendees must be greater than 0";
		if (count>100)
			result = "Estimated Attendees must be <=100";
		}
		
		catch(Exception e){
			result = "Estimated Attendees must be numeric";
		}

		return result;
	}
	
	private String validateHallName(String s) {
		
		String result = ""; 

		try {
			Integer.parseInt(getEstimated_attendees());
			}
		catch(Exception e) {
			return "";
		}
		
		Hashtable<String, String> my_dict = new Hashtable<String, String>();
		my_dict.put("Maverick",  "100");
		my_dict.put("KC",  "25");
		my_dict.put("Arlington", "50" );
		my_dict.put("Shard", "25" );
		my_dict.put("Liberty", "75" );
		
		if(Integer.parseInt(my_dict.get(s)) < Integer.parseInt(getEstimated_attendees())) {
			result = "Chosen hall too small";
		}
		return result;
	}
	
	
	
	private boolean isStringSizeBetween(String val, int minVal, int maxVal) {
		return val.length()>minVal && val.length()<maxVal;
	}
	private boolean isTextAnInteger(String val) {
		boolean isInteger;
		try
        {
            Long.parseLong(val);
            isInteger=true;
        } 
        catch (NumberFormatException e) 
        {
        	isInteger=false;
        }
		return isInteger;
		
	}



	public String getUid() {
		return uid;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}



	
	public String validateStartDate(String date) {
		
		String result = "";

		String arr[] = date.split("-");
		String year = arr[0];
		String month = arr[1];
		String day = arr[2];
		
		
		Date dNow = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dNow);
		int dNowYear = calendar.get(Calendar.YEAR);
		int dNowMonth = calendar.get(Calendar.MONTH) + 1;
		int dNowDay = calendar.get(Calendar.DAY_OF_MONTH);
		
//		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//		System.out.println("Year: "+(Integer.parseInt(year) ));
//		System.out.println("Month: "+(Integer.parseInt(month) ));
//		System.out.println("Day: "+(Integer.parseInt(day) ));
//		
//		System.out.println("Dnow Year: "+dNowYear);
//		System.out.println("DNow Month: "+dNowMonth);
//		System.out.println("Dnow Day: "+dNowDay);		
//		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		if(Integer.parseInt(year) < dNowYear ) {
			result = "Date must not be in past";
			return result;
		}
		
		if( Integer.parseInt(month) < dNowMonth ) {
			result = "Date must not be in past";
			return result;
		}
		
		 if(Integer.parseInt(month) <= dNowMonth) {
			 result = "Date must not be in past";
			return result;			
				
		}
		
		
		return result;
		
	}



	public String validateStartTime(String time) {
		
		String result = "";
		String arr[] = time.split(":");
		String hours = arr[0];
		String minutes = arr[1];
		
		Date dNow = new Date();
		
		
//		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//		System.out.println("Year: "+(Integer.parseInt(hours) ));
//		System.out.println("Month: "+(Integer.parseInt(minutes) ));
//
//		System.out.println("Dnow Year: "+dNow.getHours());
//		System.out.println("DNow Month: "+((int)dNow.getMinutes()+5));
//		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		
		if(Integer.parseInt(hours) < dNow.getHours() || Integer.parseInt(minutes)+5 < ( (int)(dNow.getMinutes()))) {
			result = "Time must not be in past";
		}
		
		return result;
		
		
	}
	
	
	public String moreDateValdiations(String date) {
		String result = "";
		
		ArrayList<EventForm> eventsInDb = EventFormDAO.getEventsByDate(date);
		if(eventsInDb.size() >= 2) {
			result = "Selected date already has 2 events";
		}
		
		if (result == "") {


			 LocalDate today = LocalDate.parse(date);

			    // Go backward to get Monday
			    LocalDate monday = today;
			    while (monday.getDayOfWeek() != DayOfWeek.MONDAY)
			    {
			      monday = monday.minusDays(1);
			    }

			    // Go forward to get Sunday
			    LocalDate sunday = today;
			    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY)
			    {
			      sunday = sunday.plusDays(1);
			    }
			    
			    String startDate = monday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			    String endDate = sunday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


//			    System.out.println("Today: " + today);
//			    System.out.println("Monday of the Week: " + startDate);
//			    System.out.println("Sunday of the Week: " + endDate);
			
			
			ArrayList<EventForm> eventsInBetweenDb = EventFormDAO.getEventsBetweenDates(startDate, endDate);
			if(eventsInBetweenDb.size() >= 5) {
				result = "Selected date already has 5 events in this week";
			}
			
			
			
		} // If result == "" close
		return result;

	}



	public double getCost() {
		return cost;
	}



	public void setCost(double d) {
		this.cost = d;
	}



	public String getCreditcard_number() {
		return creditcard_number;
	}



	public void setCreditcard_number(String creditcard_number) {
		this.creditcard_number = creditcard_number;
	}



	public String getCreditcard_expiry() {
		return creditcard_expiry;
	}



	public void setCreditcard_expiry(String creditcard_expiry) {
		this.creditcard_expiry = creditcard_expiry;
	}



	public String getCreditcard_pin() {
		return creditcard_pin;
	}



	public void setCreditcard_pin(String creditcard_pin) {
		this.creditcard_pin = creditcard_pin;
	}



	public String getEventStatus() {
		return eventStatus;
	}



	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}



	public String getAssigned_lname() {
		return assigned_lname;
	}



	public void setAssigned_lname(String assigned_lname) {
		this.assigned_lname = assigned_lname;
	}



	public String getAssigned_fname() {
		return assigned_fname;
	}



	public void setAssigned_fname(String assigned_fname) {
		this.assigned_fname = assigned_fname;
	}
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
}



	public void validateOnlyNames(EventForm eform, EventFormErrorMsgs eferrormsgs) {

		eferrormsgs.setLast_nameError(validateLastName(eform.getLast_name()));	
		eferrormsgs.setFirst_nameError(validateFirstName(eform.getFirst_name()));

		eferrormsgs.setErrorMsg();

	}
	
	
	
	


	public double totalcost() {

		double totalcost = getCost();
		double mealformalityadditionalcost = 1.0;
		
		Hashtable<String, String> hallname = new Hashtable<String, String>();
		hallname.put("Maverick", "100");
		hallname.put("KC",  "25");
		hallname.put("Arlington", "50" );
		hallname.put("Shard", "25" );
		hallname.put("Liberty", "75" );
		
		Hashtable<String, String> numofhours = new Hashtable<String, String>();
		numofhours.put("2 Hours", "2");
		numofhours.put("3 Hours",  "3");
		numofhours.put("4 Hours", "4" );
		numofhours.put("5 Hours", "5" );
		numofhours.put("6 Hours", "6" );
		numofhours.put("7 Hours", "7" );
		numofhours.put("8 Hours", "8" );
		
		
		totalcost = Integer.parseInt(hallname.get(hall_name))*2*Integer.parseInt(numofhours.get(duration));

		if (meal_formality.equals("formal")) {
			mealformalityadditionalcost =  1.5;	
		}

		Hashtable<String, String> meal_items = new Hashtable<String, String>();
		meal_items.put("BreakFast", "8");
		meal_items.put("Lunch",  "12");
		meal_items.put("Supper", "18" );
		
		System.out.println("Estimated Attendees: "+ estimated_attendees);
		System.out.println("Meal Type: "+ meal);
		
		totalcost = totalcost + ( Integer.parseInt(estimated_attendees)*Integer.parseInt(meal_items.get(meal))* mealformalityadditionalcost);

		if (drink_type.equals("Alcohol")) {
			totalcost += Integer.parseInt(estimated_attendees)*15;

		}

		if (entertainment_items.equals("Music")) {
			totalcost += 50;
		}
		
		System.out.println(totalcost);
		setCost(totalcost);
		return totalcost;

	}



	


}