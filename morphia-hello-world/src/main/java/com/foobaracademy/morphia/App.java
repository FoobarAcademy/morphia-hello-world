package com.foobaracademy.morphia;

import java.util.Date;
import java.util.List;

import org.mongodb.morphia.dao.DAO;

/**
 * Hello world!
 *
 */
public class App {
	
	
	private MorphiaService morphiaService;
	private UserDAO userDAO;
	
	public App(){
		this.morphiaService = new MorphiaService();
		this.userDAO = new UserDAOImpl(User.class, morphiaService.getDatastore());
	}
	
	
	public void saveEntityExample(){
		
		System.out.println("Save entity example");
		
		User user1 = new User("Alex", "Foo", new Date(1978, 10, 10 ), true);
		User user2 = new User("Sacha", "Foo", new Date(1989, 2, 23), false);
		User user3 = new User("Alex", "Bar", new Date(1966, 5, 2), false);
		
		System.out.println("Before persist  : ");
		System.out.println("User1 objectId " + user1.getObjectId());
		System.out.println("User2 objectId " + user2.getObjectId());
		System.out.println("User3 objectId " + user3.getObjectId());
		
		
		userDAO.save(user1);
		userDAO.save(user2);
		userDAO.save(user3);
		
		
		System.out.println("Before persist  : ");
		System.out.println("User1 objectId " + user1.getObjectId());
		System.out.println("User2 objectId " + user2.getObjectId());
		System.out.println("User3 objectId " + user3.getObjectId());
	}
	
	
	public void retrieveEntityExample(){
		
		System.out.println("Retrieve entity example ");
		
		
		System.out.println("Retrieve by firstName lastName ");
		User fetchedUser = userDAO.getByFirstNameLastName("Alex", "Bar");
		System.out.println("firstName " + fetchedUser.getFirstName());
		System.out.println("lastName " + fetchedUser.getLastName());
		System.out.println("birthDate " + fetchedUser.getBirthDate().toGMTString());
		System.out.println("hasPremiumAccess " + fetchedUser.isHasPremiumAccess());
		
		System.out.println();
		
		
		
		System.out.println("Retrive list of users by firstName ");
	
		List<User> alexs = userDAO.getByFirstName("Alex");
		for (User user : alexs) {
			System.out.println("firstName " + user.getFirstName());
			System.out.println("lastName " + user.getLastName());
			System.out.println("birthDate " + user.getBirthDate().toGMTString());
			System.out.println("hasPremiumAccess " + user.isHasPremiumAccess());
			System.out.println("-------");
		}
		
	}
	
    public static void main( String[] args ){
    	
    	App app = new App();
    	app.saveEntityExample();
    	app.retrieveEntityExample();
    }
}
