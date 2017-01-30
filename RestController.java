package com.application.controller;

import java.net.ConnectException;
import java.sql.Timestamp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.application.connection.MongoDBConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@Path("/webservice")
public class RestController {

	final static Logger logger = Logger.getLogger(MongoDBConnection.class);
	

	@SuppressWarnings("deprecation")
	@GET
	@Path("/insert/{service_id}/{action_id}/{parsed_data}")
	@Produces("text/plain")
	public String insert(@PathParam("service_id") String service_id, @PathParam("action_id") String action_id,
			@PathParam("parsed_data") String parsed_data)  {
		DB db = null;
		try {
			db = establishConnection();
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		DBCollection serviceCollection = db.getCollection("CompleteData");
		logger.debug("Services collection Insertion in process");
		if(service_id!=null && action_id != null && parsed_data!=null){
			if(!parsed_data.matches(".*\\d.*")){
			BasicDBObject doc = new BasicDBObject("service_id", service_id).
					append("action_id", action_id).append("parsed_data",parsed_data);
			serviceCollection.insert(doc);
			return "Authentication  " + db.isAuthenticated() + " ; " + "Data Inserted into " + db.getName() + " / "
					+ serviceCollection.getName();
			}else{
				return "parsed Data should not contain Numbers";
			}

		}
		else{
			return "Data is not valid";
		}
			
	}

	private DB establishConnection() throws ConnectException {
		MongoDBConnection dbSingleton = MongoDBConnection.getInstance();
		DB db = dbSingleton.getTestdb();
		return db;
		
	}

	@SuppressWarnings("deprecation")
	@GET
	@Path("/insert/{service_id}/{action_id}/{rawdata}/{status}")
	@Produces("text/plain")
	public String insert(@PathParam("service_id") String service_id, @PathParam("action_id") String action_id,
			@PathParam("rawdata") String rawdata, @PathParam("status") String status)  {
		DB db = null;
		try {
			db = establishConnection();
		} catch (ConnectException e) {
			e.printStackTrace();
		}
		DBCollection tracesCollection = db.getCollection("Traces");
		logger.debug("Traces collection Insertion in process");
		java.util.Date date = new java.util.Date();
		if(service_id!=null && action_id!=null && rawdata !=null && status !=null){
		BasicDBObject doc = new BasicDBObject("service_id", service_id).append("action_id", action_id)
				.append("timestamp", new Timestamp(date.getTime())).append("rawdata", rawdata).append("status", status);
		tracesCollection.insert(doc);
		return "Authentication  " + db.isAuthenticated() + " ; " + "Data Inserted into " + db.getName() + " / "
				+ tracesCollection.getName();
		}
		else {
			return "Data is not valid";
		}
	}

}