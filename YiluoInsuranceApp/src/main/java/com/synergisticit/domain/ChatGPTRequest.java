package com.synergisticit.domain;

import java.util.ArrayList;
import java.util.List;


public class ChatGPTRequest {
	private String model;
    private List<Message> messages;
    private int n;
    private double temperature;

    public ChatGPTRequest(String model, String prompt) {
        this.model = model;
        this.n = 1;
        this.temperature = 1;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

    
}
