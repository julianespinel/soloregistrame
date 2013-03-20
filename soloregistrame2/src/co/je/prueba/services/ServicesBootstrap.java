package co.je.prueba.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class ServicesBootstrap extends Application {

	private static Set<Object> services;

	public ServicesBootstrap() {

		services = new HashSet<Object>();

		services.add(new DeveloperServices());
		services.add(new GitHubServices());
	}

	@Override
	public Set<Object> getSingletons() {
		return services;
	}

	public static Set<Object> getServices() {
		return services;
	}
}
