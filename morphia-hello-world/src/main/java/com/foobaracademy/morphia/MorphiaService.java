package com.foobaracademy.morphia;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

/**
 * holds our Morphia and Datastore instances
 * @author Alex
 *
 */
public class MorphiaService {

	private Morphia morphia;
	private Datastore datastore;
	
	public MorphiaService(){

		// we us MongoClient to connect the local host (127.0.0.1)
		// (assuming this is where your mongodb instance is running) 
		// on port 27017 (the default port)
		MongoClient mongoClient = new MongoClient("127.0.0.1:27017");
		
		//create a new morphia instance
		this.morphia = new Morphia(); 
		String databaseName = "foobar_academy";
		this.datastore = morphia.createDatastore(mongoClient, databaseName);
	}

	
	public Morphia getMorphia() {
		return morphia;
	}

	public void setMorphia(Morphia morphia) {
		this.morphia = morphia;
	}

	public Datastore getDatastore() {
		return datastore;
	}

	public void setDatastore(Datastore datastore) {
		this.datastore = datastore;
	}
	
}
