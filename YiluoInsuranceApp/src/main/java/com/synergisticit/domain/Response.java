package com.synergisticit.domain;

public class Response {
    private String intentID;
    private String clientSecret;
	public String getIntentID() {
		return intentID;
	}
	public void setIntentID(String intentID) {
		this.intentID = intentID;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public Response(String intentID, String clientSecret) {
		super();
		this.intentID = intentID;
		this.clientSecret = clientSecret;
	}
	public Response() {
	}
}
