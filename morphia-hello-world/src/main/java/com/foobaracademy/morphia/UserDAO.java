package com.foobaracademy.morphia;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

/**
 * Our own Data Access Object interface for the User entity.
 * 
 * 
 * Note that we extend org.mongodb.morphia.dao.DAO<T,K>
 * which uses primitives : 
 * T is the Type to persist, User in this case 
 * K is the type of the entity's unique 
 * identifier, ObjectId in this case 
 * ( == The type of the field that we annotated with 
 * @Id in our User class)
 * 
 * @author Alex
 *
 */
public interface UserDAO extends DAO<User, ObjectId>{

	
	
	/**
	 * get a user using its first name and last name
	 * 
	 * (note: don't do this in the real world as 
	 * multiple users might have the 
	 * same first name and last name ... :)
	 *  
	 * @return
	 */
	public User getByFirstNameLastName(String firstName, String lastName);
	
	/**
	 * get a list of users by firstName
	 * @return
	 */
	public List<User> getByFirstName(String firstName);
	
}
