package com.application.connection;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBConnection {

	private static MongoDBConnection mDbSingleton;

	private static MongoClient mongoClient;

	private static DB db;

	private static final String dbHost = "localhost";
	private static final int dbPort = 27017;
	private static final String dbName = "CustomerData";
	private static final String dbUser = "dbUser";
	private static final String dbPassword = "dbPassword";
	final static Logger logger = Logger.getLogger(MongoDBConnection.class);


	private MongoDBConnection() {
	};

	public static MongoDBConnection getInstance() {
		if (mDbSingleton == null) {
			mDbSingleton = new MongoDBConnection();
		}
		return mDbSingleton;
	}

	@SuppressWarnings("deprecation")
	public DB getTestdb() {
		if (mongoClient == null) {
			try {
				mongoClient = new MongoClient(dbHost, dbPort);
			} catch (UnknownHostException e) {
				e.printStackTrace();
				return null;
			}
		}
		try{
		if (db == null)
			db = mongoClient.getDB(dbName);
		if (!db.isAuthenticated()) {
			logger.debug("Authentication failed");
			db.authenticate(dbUser, dbPassword.toCharArray());
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return db;
	}
}
