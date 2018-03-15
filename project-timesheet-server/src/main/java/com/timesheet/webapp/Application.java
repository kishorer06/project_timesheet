package com.timesheet.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.timesheet.webapp.model.User;
import com.timesheet.webapp.service.UserRepository;

@SpringBootApplication()
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//TODO : Only for testing need to remove later
	@Override
	public void run(String... arg0) throws Exception {
		repository.deleteAll();

		// save a couple of Users
		repository.save(new User("Alice", "Smith", "alice@gmail.com"));
		repository.save(new User("Bob", "Smith", "smith@gmail.com"));

		// fetch all Users
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (User User : repository.findAll()) {
			System.out.println(User);
		}
		System.out.println();

		// fetch an individual User
		System.out.println("User found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));
		
		System.out.println("Email found with findByEmail('alice@gmail.com'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByEmail("alice@gmail.com"));

		System.out.println("Users found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (User user : repository.findByLastName("Smith")) {
			System.out.println(user);
		}
	}

}
