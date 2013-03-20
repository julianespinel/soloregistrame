package co.je.prueba.persistence.developer;

import java.util.HashMap;
import java.util.Map;

import co.je.prueba.infrastructure.translator.DeveloperTranslator;
import co.je.prueba.persistence.DBManager;

import com.mongodb.DBObject;

public class DeveloperMapper {
	
	public void insert(DeveloperDBO developerDBO) {
		
		DBManager.getDevelopersCollection().insert(developerDBO);
	}
	
	public DeveloperDBO read(String username) {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put(DeveloperDBO.USERNAME, username);
		DeveloperDBO queryObject = DeveloperDBO.getQueryObjetc(params);
		DBObject result = DBManager.getDevelopersCollection().findOne(queryObject);
		
		DeveloperDBO developerDBO = null;
		
		if (result != null) {
			developerDBO = DeveloperTranslator.toDBO(result);
		}
		
		return developerDBO;
	}
	
	public boolean developerIsRegistered(String username) {
		
		
		Map<String, String> params = new HashMap<String, String>();
		params.put(DeveloperDBO.USERNAME, username);
		DeveloperDBO queryObject = DeveloperDBO.getQueryObjetc(params);
		DBObject result = DBManager.getDevelopersCollection().findOne(queryObject);
		
		return (result != null);
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
}