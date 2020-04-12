package catering_management.model;

import java.util.regex.*;

//import MAC_Facility.model.String;

import java.io.Serializable;
//import MAC_Facility.data.CompanyDAO;

//import company_management.data.CompanyDAO;
//import MAC_Facility.model.String;

public class Login implements Serializable{

	private static final long serialVersionUID = 3L;
	private String username;
	private String password;

	
	//private String regex  = "[1][0][0][0][0-9]{6}";
	private String regex_pwd = "(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40}";



	
	public void setLogin (String username, String password) {
		
		setUsername(username);
		setPassword(password);
		
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
	

	public void validateLogin(Login login, LoginErrorMsg errorMsgs) {
		errorMsgs.setusernameError(validateUsername(login.getUsername()));
		errorMsgs.setpasswordError(validatePassword(login.getPassword()));
		errorMsgs.setErrorMsg();
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

	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}

}