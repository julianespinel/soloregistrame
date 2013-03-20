package co.je.prueba.persistence.developer;

import java.util.Map;

import com.mongodb.BasicDBObject;

public class DeveloperDBO extends BasicDBObject {
	
	public static final String ID = "_id";
	public static final String FULLNAME = "fullname";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	
	public DeveloperDBO() {
		
		// Needed by Jackson lib.
	}
	
	public DeveloperDBO(String fullname, String username, String password) {
		
		put(FULLNAME, fullname);
		put(USERNAME, username);
		put(PASSWORD, password);
	}
	
	public String getId() {
		
		return getObjectId(ID).toString();
	}
	
	public String getFullname() {
		
		return getString(FULLNAME);
	}
	
	public String getUsername() {
		
		return getString(USERNAME);
	}
	
	public String getPassword() {
		
		return getString(PASSWORD);
	}
	
	public static DeveloperDBO getQueryObjetc(Map<String, String> paramsMap) {
		
		DeveloperDBO queryObject = new DeveloperDBO();
		queryObject.putAll(paramsMap);
		
		return queryObject;
	}
}
