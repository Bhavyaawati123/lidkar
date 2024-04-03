package com.backend.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String mobileNumber;
    private String password;
    private Date dateOfBirth;
    private String address;
	public User() {
		super();
	}
	public User(Long userId, String firstName, String lastName, String userName, String email, String mobileNumber,
			String password, Date dateOfBirth, String address) {
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
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the authorities (roles) granted to the user. You may need to implement this depending on your application's requirements.
        return null;
    }

    @Override
    public String getUsername() {
        // Return the username used to authenticate the user.
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Indicates whether the user's account has expired.
        // Return true if the user's account is valid (i.e., not expired), false otherwise.
        return true; // Implement your logic here
    }

    @Override
    public boolean isAccountNonLocked() {
        // Indicates whether the user is locked or unlocked.
        // Return true if the user is not locked, false otherwise.
        return true; // Implement your logic here
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Indicates whether the user's credentials (password) has expired.
        // Return true if the user's credentials are valid (i.e., not expired), false otherwise.
        return true; // Implement your logic here
    }

    @Override
    public boolean isEnabled() {
        // Indicates whether the user is enabled or disabled.
        // Return true if the user is enabled, false otherwise.
        return true; // Implement your logic here
    }
	public static Object withUsername(String email2) {
		// TODO Auto-generated method stub
		return null;
	}
  

}