package com.fis.theatre.web.dto;

public class TokenResponseDTO {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TokenResponseDTO(String token) {
		super();
		this.token = token;
	}

	public TokenResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
