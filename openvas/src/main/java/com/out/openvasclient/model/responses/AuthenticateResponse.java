package com.out.openvasclient.model.responses;

public class AuthenticateResponse extends Response {

	private String role;
	
	private String timezone;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Override
	public String toString() {
		return "AuthenticateResponse [role=" + role + ", timezone=" + timezone
				+ ", status=" + status + ", statusText=" + statusText + "]";
	}
	
	
}
