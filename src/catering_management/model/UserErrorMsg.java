package catering_management.model;

public class UserErrorMsg {
	private String errorMsg;
	private String usernameError;
	private String first_nameError;
	private String last_nameError;
	private String roleError;

	public UserErrorMsg() {
		this.errorMsg = "";
		this.usernameError = "";
		this.first_nameError = "";
		this.last_nameError = "";
		this.roleError = "";
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg() {
		if (!usernameError.equals("") || !last_nameError.equals("") || !roleError.equals(""))
			this.errorMsg = "Please correct the following errors";
	}

	public String getUsernameError() {
		return usernameError;
	}

	public void setUsernameError(String usernameError) {
		this.usernameError = usernameError;
	}

	public String getLastNameError() {
		return last_nameError;
	}

	public void setLastNameError(String lastNameError) {
		this.last_nameError = lastNameError;
	}


	public String getRoleError() {
		return roleError;
	}

	public void setRoleError(String roleError) {
		this.roleError = roleError;
	}
}
