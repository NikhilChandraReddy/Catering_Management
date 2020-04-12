package catering_management.model;

public class RegistrationErrorMsg {

	private String errorMsg;
	private String usernameError;
	private String passwordError;
	private String last_nameError;
	private String first_nameError;
	private String roleError;
	private String utaIDError;
	private String phoneError;
	private String emailError;
	private String street_numberError;
	private String street_nameError;
	private String cityError;
	private String stateError;
	private String zipcodeError;
	

	
	public RegistrationErrorMsg() {
		this.errorMsg = "";
		this.usernameError = "";
		this.passwordError = "";
		this.last_nameError = "";
		this.first_nameError = "";
		this.roleError = "";
		this.utaIDError = "";
		this.phoneError = "";
		this.emailError = "";
		this.street_numberError = "";
		this.street_nameError = "";
		this.cityError = "";
		this.stateError = "";
		this.zipcodeError = "";
					
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!usernameError.equals("") || !passwordError.equals("")  || !last_nameError.equals("") || !first_nameError.equals("") || !roleError.equals("") || !utaIDError.equals("") || !phoneError.equals("") || !emailError.equals("") || !street_numberError.equals("") || !street_nameError.equals("") || !cityError.equals("") || !stateError.equals("") || !zipcodeError.equals("") )   
			this.errorMsg = "Please correct the following errors";
	}
	public void setErrorMsgnotrole() {
		if (!usernameError.equals("") || !passwordError.equals("")  || !last_nameError.equals("") || !first_nameError.equals("") || !utaIDError.equals("") || !phoneError.equals("") || !emailError.equals("") || !street_numberError.equals("") || !street_nameError.equals("") || !cityError.equals("") || !stateError.equals("") || !zipcodeError.equals("") )   
			this.errorMsg = "Please correct the following errors";
	}
	
	public String getusernameError() {
		return usernameError;
	}
	
	public void setusernameError(String usernameError) {
		this.usernameError = usernameError;
	}
	
	public String getpasswordError() {
		return passwordError;
	}
	
	public void setpasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	
	public String getlast_nameError() {
		return last_nameError;
	}
	
	public void setlast_nameError(String last_nameError) {
		this.last_nameError = last_nameError;
	}
	
	public String getfirst_nameError() {
		return first_nameError;
	}
	
	public void setfirst_nameError(String first_nameError) {
		this.first_nameError = first_nameError;
	}
	
	public String getroleError() {
		return roleError;
	}
	
	public void setroleError(String roleError) {
		this.roleError = roleError;
	}
	
	public String getutaIDError() {
		return utaIDError;
	}
	
	public void setutaIDError(String utaIDError) {
		this.utaIDError = utaIDError;
	}
	
	public String getphoneError() {
		return phoneError;
	}
	
	public void setphoneError(String contactError) {
		this.phoneError = contactError;
	}
	
	public String getemailError() {
		return emailError;
	}
	
	public void setemailError(String emailError) {
		this.emailError = emailError;
	}
	
	public String getstreet_numberError() {
		return street_numberError;
	}
	
	public void setstreet_numberError(String street_numberError) {
		this.street_numberError = street_numberError;
	}
	
	public String getstreet_nameError() {
		return street_nameError;
	}
	
	public void setstreet_nameError(String street_nameError) {
		this.street_nameError = street_nameError;
	}

	public String getcityError() {
		return cityError;
	}
	
	public void setcityError(String cityError) {
		this.cityError = cityError;
	}
	
	public String getstateError() {
		return stateError;
	}
	
	public void setstateError(String stateError) {
		this.stateError = stateError;
	}
		
	public String getzipcodeError() {
		return zipcodeError;
	}
	
	public void setzipcodeError(String zipcodeError) {
		this.zipcodeError = zipcodeError;
	}
	
}