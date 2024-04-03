package com.backend.dto;

import java.util.Date;

public class UserDto {

	 private Long userId;
	    private String firstName;
	    private String lastName;
	    private String userName;
	    private String email;
	    private String mobileNumber;
	    private String password;
	    private Date dateOfBirth;
	    private String address;
	
		public UserDto() {
			super();
		}
		public UserDto(Long userId, String firstName, String lastName, String userName, String email,
				String mobileNumber, String password, Date dateOfBirth, String address) {
			super();
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.email = email;
			this.mobileNumber = mobileNumber;
			this.password = password;
			this.dateOfBirth = dateOfBirth;
			this.address = address;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
}
