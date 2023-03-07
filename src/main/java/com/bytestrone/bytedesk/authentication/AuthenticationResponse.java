package com.bytestrone.bytedesk.authentication;

public class AuthenticationResponse {

	private String token;
	private String userName;
	private String image;
	private String salutation;
	private String userId;
	private String department;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public AuthenticationResponse() {
		super();
	
	}
	public String getToken() {
		return token;
	}
	public AuthenticationResponse(String token, String userName, String image, String salutation) {
		super();
		this.token = token;
		this.userName = userName;
		this.image = image;
		this.salutation = salutation;
	}
	public AuthenticationResponse(String salutation) {
		super();
		this.salutation = salutation;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
//	public static Object builder() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
