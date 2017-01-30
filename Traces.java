package com.application.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Traces")
public class Traces implements Serializable  {

	
	private static final long serialVersionUID = 4551626870716137088L;
	
	@Id
	private String service_id;
	private String action_id;
	private String timestamp;
	private String rawdata;
	private String status;
	
	
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
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getRawdata() {
		return rawdata;
	}
	public void setRawdata(String rawdata) {
		this.rawdata = rawdata;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Traces [service_id=" + service_id + ", action_id=" + action_id + ", timestamp=" + timestamp
				+ ", rawdata=" + rawdata + ", status=" + status + "]";
	}
	
	
}
