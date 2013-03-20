package co.je.prueba.dtos;

public class DeveloperDTO {
	
	private String id;
	private String fullname;
	private String username;
	private String password;
	
	public DeveloperDTO() {
		
		// Needed by Jackson lib.
	}

	public DeveloperDTO(String id, String fullname, String username, String password) {
		
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
