package com.foobaracademy.morphia;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;


/**
 * implementation of 
 * @author Alex
 *
 */
public class UserDAOImpl extends BasicDAO<User, ObjectId> implements UserDAO {

	public UserDAOImpl(Class<User> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

	public User getByFirstNameLastName(String firstName, String lastName) {
		Query<User> query = createQuery().
				field("firstName").equal(firstName).
				field("lastName").equal(lastName);
		
		return query.get();
	}

	public List<User> getByFirstName(String firstName) {

		Query<User> query = createQuery().
				field("firstName").equal(firstName);
		
		return query.asList();
	}

}
