package com.randhir.QuizApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

// to store the result model
@Entity
@Data
public class Response {
	@Id
	private Integer id;
	private String response;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
