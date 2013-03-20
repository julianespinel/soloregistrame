package co.je.prueba.persistence;

import java.net.UnknownHostException;

import co.je.prueba.persistence.developer.DeveloperDBO;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class DBManager {
	
	/**
	 * The DB name.
	 */
	public static final String DB_NAME = "soloregistrame_db";

	/**
	 * The name of the collection in which the entities are stored.
	 */
	public static final String DEVELOPERS_COLLECTION = "developers";

	/**
	 * The name of the collection in which the complaints are stored.
	 */
	public static final String REPOSITORIES_COLLECTION = "repositories";

	/**
	 * Attribute that represents the DB connection.
	 */
	private static Mongo mongoInstance;

	/**
	 * Attribute that represents the system's DB instance.
	 */
	private static DB soloRegistraMeDBInstance;

	/**
	 * DBManager constructor.
	 */
	private DBManager() {
	}

	/**
	 * Returns the unique instance of the system's DB.
	 *
	 * @return the unique instance of the system's DB.
	 */
	private static DB getSoloRegistraMeDBInstance() {

		if (mongoInstance == null) {

			try {

				mongoInstance = new Mongo();

			} catch (UnknownHostException e) {

				e.printStackTrace();
			}
		}

		if (soloRegistraMeDBInstance == null) {

			soloRegistraMeDBInstance = mongoInstance.getDB(DB_NAME);
		}

		return soloRegistraMeDBInstance;
	}
	
	public static DBCollection getDevelopersCollection() {
		
		DBCollection entitiesCollection = getSoloRegistraMeDBInstance().getCollection(DEVELOPERS_COLLECTION);
		entitiesCollection.setObjectClass(DeveloperDBO.class);
		
		return entitiesCollection;
	}
	
	// TODO getRepositoriesCollection()
}
