package co.je.prueba.dtos;


public class RepositoryDTO {
	
	private String name;
	private String description;
	private String repositoryUrl;
	private String commitsUrl;
	
	public RepositoryDTO() {
		
		// Needed by Jackson lib
	}

	public RepositoryDTO(String name, String description, String repositoryUrl, String commitsUrl) {
		
		this.name = name;
		this.description = description;
		this.repositoryUrl = repositoryUrl;
		this.commitsUrl = commitsUrl;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getRepositoryUrl() {
		return repositoryUrl;
	}

	public String getCommitsUrl() {
		return commitsUrl;
	}
}