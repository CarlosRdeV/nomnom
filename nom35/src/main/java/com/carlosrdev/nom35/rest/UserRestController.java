package com.carlosrdev.nom35.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlosrdev.nom35.dao.UserRepository;
import com.carlosrdev.nom35.entity.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

	// fields

	private UserRepository userRepository;

	// constructor injection

	@Autowired
	public UserRestController(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}

	////////////////////
	// TEST ENDPOINTS //
	////////////////////

	@GetMapping("users/test")
	public String test() {
		return "IT WORKS USERS!!!";
	}

	////////////////////
	// USER ENDPOINTS //
	////////////////////

	// add mapping for GET /users - return list of all users
	@GetMapping("/users")
	public List<User> findAll() {

		return userRepository.findAll();
	}

	// add mapping for GET /users/{userId} - return the user selected if exist
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {

		Optional<User> result = userRepository.findById(userId);

		User theUser = null;

		if (result.isPresent()) {
			theUser = result.get();
		} else {
			throw new RuntimeException("Did not find user id - " + userId);
		}

		return theUser;

	}

	// add mapping for POST /users - add new user
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {

		theUser.setId(0);

		userRepository.save(theUser);

		return theUser;

	}

}
