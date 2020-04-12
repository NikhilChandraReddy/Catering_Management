package catering_management.model;
import java.util.regex.*;  

import java.io.Serializable;

public class Registration implements Serializable{

	private static final long serialVersionUID = 3L;;
	private String username = "";
	private String password = "";
	private String first_name = "";
	private String last_name= "";
	private String role = "";
	private String uta_id = "";
	private String phone = "";
	private String email = "";
	private String street_number = "";
	private String street_name = "";
	private String city = "";
	private String zip_code = "";
	private String state = "";
	
	//private String regex  = "[^A-Za-z0-9]";
	private String regex_pwd = "(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40}";


	
	public void setRegistration (String username, String password, String last_name, String first_name,String role, String uta_id, String phone, String email,String street_number,String street_name, String city, String state, String zip_code) {
		setUsername(username);
		setPassword(password);
		setLastName(last_name);
		setFirstName(first_name);
		setRole(role);
		setUtaId(uta_id);
		setPhone(phone);
		setEmail(email);
		setStreet_Number(street_number);
		setStreet_Name(street_name);
		setCity(city);
		setState(state);
		setZipCode(zip_code);

	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getUtaId() {
		return uta_id;
	}
	public void setUtaId(String uta_id) {
		this.uta_id = uta_id;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
        this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStreet_Number() {
		return street_number;
	}
	public void setStreet_Number(String street_number) {
		this.street_number = street_number;
	}

	public String getStreet_Name() {
		return street_name;
	}
	public void setStreet_Name(String street_name) {
		this.street_name = street_name;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipCode() {
		return zip_code;
	}
	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}
	



	

	public void validateRegistration (Registration registration, RegistrationErrorMsg errorMsgs) {
//		if (action.equals("save_registration_details")) {
			errorMsgs.setusernameError(validateUsername(registration.getUsername()));
			errorMsgs.setpasswordError(validatePassword(registration.getPassword()));
			errorMsgs.setlast_nameError(validateLastName(registration.getLastName()));
			errorMsgs.setfirst_nameError(validateFirstName(registration.getFirstName()));
			errorMsgs.setroleError(validateRole(registration.getRole()));			
			errorMsgs.setutaIDError(validateUtaId(registration.getUtaId()));			
			errorMsgs.setphoneError(validatePhone(registration.getPhone()));
			errorMsgs.setemailError(validateEmail(registration.getEmail()));	
			errorMsgs.setstreet_numberError(validateStreet_Number(registration.getStreet_Number()));
			errorMsgs.setstreet_nameError(validateStreet_Name(registration.getStreet_Name()));
			errorMsgs.setcityError(validateCity(registration.getCity()));
			errorMsgs.setstateError(validateState(registration.getState()));
			errorMsgs.setzipcodeError(validateZipCode(registration.getZipCode()));
			errorMsgs.setErrorMsg();

	}
	
	public void validateRegistrationnotrole(Registration registration, RegistrationErrorMsg errorMsgs) {
//		if (action.equals("save_registration_details")) {
			errorMsgs.setusernameError(validateUsername(registration.getUsername()));
			errorMsgs.setpasswordError(validatePassword(registration.getPassword()));
			errorMsgs.setlast_nameError(validateLastName(registration.getLastName()));
			errorMsgs.setfirst_nameError(validateFirstName(registration.getFirstName()));
			errorMsgs.setutaIDError(validateUtaId(registration.getUtaId()));			
			errorMsgs.setphoneError(validatePhone(registration.getPhone()));
			errorMsgs.setemailError(validateEmail(registration.getEmail()));	
			errorMsgs.setstreet_numberError(validateStreet_Number(registration.getStreet_Number()));
			errorMsgs.setstreet_nameError(validateStreet_Name(registration.getStreet_Name()));
			errorMsgs.setcityError(validateCity(registration.getCity()));
			errorMsgs.setstateError(validateState(registration.getState()));
			errorMsgs.setzipcodeError(validateZipCode(registration.getZipCode()));
			errorMsgs.setErrorMsgnotrole();

	}


	
	private String validateUsername(String username) {
		String error="";
	    Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
	    Matcher matcher = pattern.matcher(username);
		
		if (!stringSize(username,5,20))
			error= "Username length must be >4 and <=20";
		else
			if (!Character.isLetter(username.charAt(0)))
					error= "Username must start with a letter";		
			else
				if(!matcher.matches())
					error="Username cannot contain special characters";
		return error;
	}

	private String validatePassword(String password) {
		String result="";
		if (!stringSize(password,8,29))
			result= "Password length must be >7 and <30";
		else
//				if (action.equals("save_registration_details")) 
			  if(!Pattern.matches(regex_pwd, password))
				  result= "Your Password must contain at least 1 uppercase letter 1 lowercase letter 1 number and 1 special character and should be 8-40 characters long.";
		return result;
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
	
	private String validateRole(String role) {
		String error="";
		if (role.equals("Admin"))
			error="Only one Admin in the system";
		else
			if (role.equals("Caterer_Manager"))
				error="Only one Catering Manager in the system";	
		return error;
	}

	
	private String validateUtaId(String uta_id) {
		String result="";
		if (!isTextAnInteger(uta_id))
			result="UTA ID must be numeric";
		else
//			if (action.equals("save_registration_details")) 
			if (uta_id.length()!=10)
				result= "UTA ID must be 10 digits in length.";
		
		return result;
	}

	private String validatePhone(String phone) {
		String error="";
		if (phone.length()!=10)
			error="Phone number must be 10 digits in length";
		else
			if (!isTextAnInteger(phone))
				error="Phone number must be a number";
		return error;		
	}

	private String validateEmail(String email) {
		String error="",extension="";
		if (!email.contains("@"))
			error = "Email address needs to contain @";
		else
			if (!stringSize(email,7,45))
				error="Email address must be between 7 and 45 characters long";
			else {
				extension = email.substring(email.length()-4, email.length());
				if (!extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com") 
						&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil"))
					error = "Invalid domain name";				
			}
		return error;		
	}
	
	private String validateStreet_Number(String street_number) {
		String error="";
		if (!isTextAnInteger(street_number))
			error="Street_Number must be a number";
		else
			if (!(Integer.parseInt(street_number)>0))
				error="Street number must be >0";
			else
				if (!stringSize(street_number,1,6))
					error= "Street Number length must be >0 and <7";
				
	return error;		
	}
		
	private String validateStreet_Name(String street_name) {
		String error="";
	    Pattern pattern1 = Pattern.compile("[a-zA-Z]*");
	    Matcher matcher1= pattern1.matcher(street_name);

		if (street_name.length()<=0)
			error= "Street name length must be greater than zero";
		else
//			if (action.equals("save_registration_details")) 
			if (!matcher1.matches())
				error="Your street name must be non numeric";
			else
				if (street_name.length()>40)
					error= "Street name length must be less than 40";

		return error;
	}
	
	private String validateCity(String city) {
		String error="";
	    Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
	    Matcher matcher = pattern.matcher(city);
	    
	    Pattern pattern1 = Pattern.compile("[a-zA-Z]*");
	    Matcher matcher1= pattern1.matcher(city);
		
		
	    if(!matcher.matches())
			error="City cannot contain special characters";
		else
//			if (action.equals("save_registration_details")) 
			if (!stringSize(city,3,30))
				error= "City must between 3 and 40 characters.";
			else
//				if (action.equals("save_registration_details")) 
				if (Character.isLowerCase(city.charAt(0)))
					error= "City must start with a capital letter.";
				else
					if (!matcher1.matches())
						error="City must be non-numeric";
		//System.out.println(error);
		return error;
	}
	
	
	private String validateState(String state) {
		String error="";
	    Pattern pattern1 = Pattern.compile("[a-zA-Z]*");
	    Matcher matcher1= pattern1.matcher(state);
		
		String states = "|AL|AK|AS|AZ|AR|CA|CO|CT|DE|DC|FM|FL|GA|GU|HI|ID|IL|IN|IA|KS|KY|LA|ME|MH|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|MP|OH|OK|OR|PW|PA|PR|RI|SC|SD|TN|TX|UT|VT|VI|VA|WA|WV|WI|WY|";
		if (state.length()!=2)
			error="State must be a 2 letter abbreviation";
		else
			if (!matcher1.matches())
				error="State must be non-numeric";
			else 
				if(states.indexOf( state ) < 0)
					error="State abbreviation not found";
		return error;		
	}
	
	private String validateZipCode(String zip_code) {
		String result="";
		if (zip_code.length()!=5)
			result="Zip Code must be 5 digits in length";
		else
			if (!isTextAnInteger(zip_code))
				result="Zip Code must be a number";
		return result;		
	}
	

////	This section is for general purpose methods used internally in this class
//	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}
}