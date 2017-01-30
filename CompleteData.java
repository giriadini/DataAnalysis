package com.application.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CompleteData")
public class CompleteData implements Serializable {

	private static final long serialVersionUID = 4248422404447093593L;
	
	@Id
	private String service_id;
	private String action_id;
	private String parsed_data;
	
	public String getService_id() {
		return service_id;
	}
	public void setService_id(String service_id) {
		this.service_id = service_id;
	}
	public String getAction_id() {
		return action_id;
	}
	public void setAction_id(String action_id) {
		this.action_id = action_id;
	}
	public String getParsed_data() {
		return parsed_data;
	}
	public void setParsed_data(String parsed_data) {
		this.parsed_data = parsed_data;
	}
	
	@Override
	public String toString() {
		return "data [service_id=" + service_id + ", action_id=" + action_id + ", parsed_data=" + parsed_data + "]";
	}



}
