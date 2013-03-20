package co.je.prueba.infrastructure.translator;

import java.util.Map;

import com.mongodb.DBObject;

import co.je.prueba.dtos.DeveloperDTO;
import co.je.prueba.persistence.developer.DeveloperDBO;

public class DeveloperTranslator {
	
	public static DeveloperDBO toDBO(DeveloperDTO developerDTO) {
		
		return new DeveloperDBO(developerDTO.getFullname(), developerDTO.getUsername(), 
				developerDTO.getPassword());
	}
	
	public static DeveloperDTO toDTO(DeveloperDBO developerDBO) {
		
		return new DeveloperDTO(developerDBO.getId(), developerDBO.getFullname(), 
				developerDBO.getUsername(), developerDBO.getPassword());
	}
	
	public static DeveloperDBO toDBO(DBObject dbo) {
		
		Map<String, String> map = dbo.toMap();
		return DeveloperDBO.getQueryObjetc(map);
	}
}
