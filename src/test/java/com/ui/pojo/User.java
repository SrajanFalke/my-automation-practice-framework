package com.ui.pojo;

public class User {

	private String emailId; // we have assign this emailId variable as same as that we have taken in out
							// testData.json file...
	private String password; // we have assign this Password variable as same as that we have taken in out
								// testData.json file...

	public User(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + password + "]";
	}

}

// iske baad hum ek or class testData ke naam se create karenge jaha hum user class ka data list ke sath collect krenge.
