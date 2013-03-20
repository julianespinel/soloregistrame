package co.je.prueba.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.je.prueba.dtos.DeveloperDTO;
import co.je.prueba.infrastructure.translator.DeveloperTranslator;
import co.je.prueba.persistence.developer.DeveloperDBO;
import co.je.prueba.persistence.developer.DeveloperMapper;

@Path("developers")
public class DeveloperServices {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerDeveloper(DeveloperDTO developerDTO) {
		
		System.out.println("DeveloperServices: registerDeveloper");
		
		DeveloperDBO developerDBO = DeveloperTranslator.toDBO(developerDTO);
		DeveloperMapper developerMapper = new DeveloperMapper();
		developerMapper.insert(developerDBO);
		
		Response response = Response.status(201).build();
		
		return response;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateDeveloper(@QueryParam("username") String username) {
		
		System.out.println("DeveloperServices: authenticateDeveloper: param: " + username);

		DeveloperMapper developerMapper = new DeveloperMapper();
		DeveloperDBO developerDBO = developerMapper.read(username);
		
		Response response = Response.status(401).build();
		
		if (developerDBO != null) {
			
			DeveloperDTO developerDTO = DeveloperTranslator.toDTO(developerDBO);
			response = Response.status(200).entity(developerDTO).build();
		}
		
		return response;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDeveloper(DeveloperDTO developerDTO) {
		
		System.out.println("DeveloperServices: updateDeveloper");
		
		System.out.println("update developer");
		Response response = Response.status(201).build();
		
		return response;
	}
}
