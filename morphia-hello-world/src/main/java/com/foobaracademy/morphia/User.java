package com.foobaracademy.morphia;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("user")
public class User {

	@Id
	private ObjectId objectId;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthDate;
	
	private boolean hasPremiumAccess;

	/**
	 * keep an empty constructor so that morphia 
	 * can recreate this entity when you want to 
	 * fetch it from the database
	 */
	public User(){}
	
	
	/**
	 * full constructor 
	 * (without objectId, we let morphia generate this one for us) 
	 * 
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param hasPremiumAccess
	 */
	public User(String firstName, String lastName, Date birthDate,
			boolean hasPremiumAccess) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.hasPremiumAccess = hasPremiumAccess;
	}
	
	
	

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isHasPremiumAccess() {
		return hasPremiumAccess;
	}

	public void setHasPremiumAccess(boolean hasPremiumAccess) {
		this.hasPremiumAccess = hasPremiumAccess;
	}
	
	
}
