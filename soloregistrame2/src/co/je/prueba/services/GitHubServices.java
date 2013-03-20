package co.je.prueba.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;

import co.je.prueba.dtos.RepositoryDTO;

@Path("repositories")
public class GitHubServices {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RepositoryDTO> getUserRepositories(@QueryParam("username") String username) {
		
		List<RepositoryDTO> repositoriesDTO = new ArrayList<RepositoryDTO>();
		
		try {
			
			RepositoryService repoService = new RepositoryService();
			List<Repository> gitHubRepos = repoService.getRepositories(username);
			
			for (int i = 0; i < gitHubRepos.size(); i++) {
				
				Repository repo = gitHubRepos.get(i);
				
//				CommitService commitService = new CommitService();
//				List<RepositoryCommit> commits = commitService.getCommits(repo);
//				
//				String repositoryCommitsUrl = "";
//				
//				if (commits.size() > 0) {
//					
//					repositoryCommitsUrl = commits.get(0).getUrl();
//				}
				
				String repositoryName = repo.getName();
				String repositoryCommitsUrl = "https://github.com/" + username + "/" + repositoryName + "/commits";
				
				RepositoryDTO repositoryDTO = new RepositoryDTO(repositoryName, repo.getDescription(), 
						repo.getHtmlUrl(), repositoryCommitsUrl);
				
				repositoriesDTO.add(repositoryDTO);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return repositoriesDTO;
	}
}