package catering_management.model;


public class EventFormErrorMsgs {

	private String errorMsg = "";
	private String last_nameError = "";
	private String first_nameError = "";
	private String start_dateError = "";
	private String start_timeError = "";
	private String durationError = "";
	private String hall_nameError = "";
	private String estimated_attendeesError = "";
	private String event_nameError = "";
	private String food_typeError = "";
	private String mealError = "";
	private String meal_formalityError = "";
	private String drink_typeError = "";
	private String entertainment_itemsError = "";
	private String creditcard_numberError = "";
	private String creditcard_expiryError = "";
	private String creditcard_pinError = "";
	private String assignedlast_nameError = "";
	private String assignedfirst_nameError = "";
	
	public String getAssignedLast_nameError() {
		return assignedlast_nameError;
	}
	public void setAssignedLast_nameError(String assignedlast_nameError) {
		this.assignedlast_nameError = assignedlast_nameError;
	}
	public String getAssignedFirst_nameError() {
		return assignedfirst_nameError;
	}
	public void setAssignedFirst_nameError(String assignedfirst_nameError) {
		this.assignedfirst_nameError = assignedfirst_nameError;
	}
	
	public String getLast_nameError() {
		return last_nameError;
	}
	public void setLast_nameError(String last_nameError) {
		this.last_nameError = last_nameError;
	}
	public String getFirst_nameError() {
		return first_nameError;
	}
	public void setFirst_nameError(String first_nameError) {
		this.first_nameError = first_nameError;
	}
	public String getStart_dateError() {
		return start_dateError;
	}
	public void setStart_dateError(String start_dateError) {
		this.start_dateError = start_dateError;
	}
	public String getStart_timeError() {
		return start_timeError;
	}
	public void setStart_timeError(String start_timeError) {
		this.start_timeError = start_timeError;
	}
	public String getDurationError() {
		return durationError;
	}
	public void setDurationError(String durationError) {
		this.durationError = durationError;
	}
	public String getHall_nameError() {
		return hall_nameError;
	}
	public void setHall_nameError(String hall_nameError) {
		this.hall_nameError = hall_nameError;
	}
	public String getEstimated_attendeesError() {
		return estimated_attendeesError;
	}
	public void setEstimated_attendeesError(String estimated_attendeesError) {
		this.estimated_attendeesError = estimated_attendeesError;
	}
	public String getEvent_nameError() {
		return event_nameError;
	}
	public void setEvent_nameError(String event_nameError) {
		this.event_nameError = event_nameError;
	}
	public String getFood_typeError() {
		return food_typeError;
	}
	public void setFood_typeError(String food_typeError) {
		this.food_typeError = food_typeError;
	}
	public String getMealError() {
		return mealError;
	}
	public void setMealError(String mealError) {
		this.mealError = mealError;
	}
	public String getMeal_formalityError() {
		return meal_formalityError;
	}
	public void setMeal_formalityError(String meal_formalityError) {
		this.meal_formalityError = meal_formalityError;
	}
	public String getDrink_typeError() {
		return drink_typeError;
	}
	public void setDrink_typeError(String drink_typeError) {
		this.drink_typeError = drink_typeError;
	}
	public String getEntertainment_itemsError() {
		return entertainment_itemsError;
	}
	public void setEntertainment_itemsError(String entertainment_itemsError) {
		this.entertainment_itemsError = entertainment_itemsError;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!(last_nameError.equals(""))|| !(first_nameError.equals(""))|| !(assignedfirst_nameError.equals(""))|| !(assignedlast_nameError.equals("")) || !(start_dateError.equals("")) || !(start_timeError.equals(""))   || !(durationError.equals(""))  ||  !(hall_nameError.equals(""))  ||  !(estimated_attendeesError.equals(""))  ||  !(event_nameError.equals("")) || !(creditcard_numberError.equals(""))   || !(creditcard_expiryError.equals(""))  || !(creditcard_pinError.equals("")))
		{
			this.errorMsg = "Please correct the following errors"; 	}
	}
	public String getCreditcard_numberError() {
		return creditcard_numberError;
	}
	public void setCreditcard_numberError(String creditcard_numberError) {
		this.creditcard_numberError = creditcard_numberError;
	}
	public String getCreditcard_expiryError() {
		return creditcard_expiryError;
	}
	public void setCreditcard_expiryError(String creditcard_expiryError) {
		this.creditcard_expiryError = creditcard_expiryError;
	}
	public String getCreditcard_pinError() {
		return creditcard_pinError;
	}
	public void setCreditcard_pinError(String creditcard_pinError) {
		this.creditcard_pinError = creditcard_pinError;
	}
	
}