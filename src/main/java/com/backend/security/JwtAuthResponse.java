package com.backend.security;

import com.backend.dto.UserDto;

public class JwtAuthResponse {

	private String token;
	
	private UserDto user;

	public JwtAuthResponse() {
		super();
	}

	public JwtAuthResponse(String token, UserDto user) {
		super();
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
}