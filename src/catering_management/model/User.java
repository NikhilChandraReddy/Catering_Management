 package catering_management.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import company_management.data.CompanyDAO;
import catering_management.data.UserDAO;

public class User implements Serializable {

	private static final long serialVersionUID = 3L;
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

	public void setUser (String username, String password, String last_name, String first_name,String role, String uta_id, String phone, String email,String street_number,String street_name, String city, String state, String zip_code) {
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
/*		public void validateUser(String action, User user, UserErrorMsg errorMsgs) {
			if (action.equalsIgnoreCase("searchUser")) {

				if (last_name.equalsIgnoreCase("")) {
					errorMsgs.setLastNameError("Last Name cannot be blank");
				} else {
					errorMsgs.setLastNameError(validatLast_name(last_name));
				}
				errorMsgs.setErrorMsg();
			}
		}
		
*/
		public void validateUserMore( User user, UserErrorMsg errorMsgs) {

				
				errorMsgs.setLastNameError(validatLast_name(user.getLastName()));
				errorMsgs.setUsernameError(validateUser_name(user.getUsername()));
				errorMsgs.setRoleError(validateRole(user.getRole()));
				errorMsgs.setErrorMsg();

		}

		private String validateUser_name(String username) {
			// Username: is not numeric 8 <= Length <= 20 unique (not in DB)
			String result = "";
			//System.out.println(username);
			if (!stringSize(username, 5, 20)) {
				result = "Your User Name must between 5 and 20 characters";
			} else if (isTextAnInteger(username)) {
				result = "Your user name cannot be numeric";
			} else if (!UserDAO.userExists(username)) {
				result = "Given user does not exist in database please provide a username for a pre-existing user";
			}
			return result;
		}

		private String validatLast_name(String lastname) {
			// Last name: Starts with Capital Letter, 3 <= Length <= 40, Contains no numeric
			// values
			String result = "";
			if (!stringSize(lastname, 3, 40))
				result = "Your Last Name must be between 3 and 40 characters";
			else if (Character.isLowerCase(lastname.charAt(0))) {
				result = "Your last name must start with a capital letter";
			} else if (containsNumericValue(lastname))
				result = "Your last name cannot contain any numeric values";
			return result;
		}


		
		public String validateRole(String role) {
			String error="";
			if (role.equals("Admin"))
				error="Only one Admin in the system";
			else
				if (role.equals("Caterer_Manager"))
					error="Only one Catering Manager in the system";	
			return error;
		}

//		private String validatFirst_name(String first_name) {
//		String result = "";
//		if (!stringSize(first_name, 3, 40))
//			result = "Your Last Name must be between 3 and 40 characters";
//		else if (Character.isLowerCase(first_name.charAt(0)))
//			result = "Your last name must start with a capital letter";
//		else if (containsNumericValue(first_name))
//			result = "Your last name should not contain any numeric values";
//		return result;
	//}

//		private String validatePhone(String phone) {
//			String result = "";
//			if (phone.length() != 10)
//				result = "Phone number must be 10 digits in length";
//			else if (!isTextAnInteger(phone))
//				result = "Phone number must be a number";
//			return result;
//		}

//		private String validateEmail(String email) {
//			String result = "", extension = "";
//			if (!email.contains("@"))
//				result = "Email address needs to contain @";
//			else if (!stringSize(email, 7, 45))
//				result = "Email address must be between 7 and 45 characters long";
//			else {
//				extension = email.substring(email.length() - 4, email.length());
//				if (!extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com")
//						&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil"))
//					result = "Invalid domain name";
//			}
//			return result;
//		}

	private boolean stringSize(String string, int min, int max) {
		return string.length() >= min && string.length() <= max;
	}

	private boolean isTextAnInteger(String string) {
		boolean result;
		try {
			Long.parseLong(string);
			result = true;
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}

	private boolean containsNumericValue(String string) {
		boolean result;
		if (string.matches(".*\\d.*")) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}