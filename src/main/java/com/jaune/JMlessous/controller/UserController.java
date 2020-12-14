package com.jaune.JMlessous.controller;


import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.User;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class UserController {
	
	
	 @Autowired
		com.jaune.JMlessous.dao.UserDaoImpl  userDaoImpl;
		


	@GetMapping(value = "/login/{username}/{password}")
	public User getUser2(@PathVariable(value = "username") String username,@PathVariable(value = "password") String password) {
	return userDaoImpl.findByUser(username, password);
	}
	
	
	 @GetMapping("/users")
	    public List<User> getAllUsers() {
	        return userDaoImpl.getAllUsers();
	    }
	
	    @GetMapping("/users/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId)
	        throws ResourceNotFoundException {	    	
	        return userDaoImpl.getUserById(userId);
	    }
	    
	    @PostMapping("/users")
	    public User createUser(@Validated @RequestBody User user) {
	        return userDaoImpl.createUser(user);
	    }

	    @PutMapping("/users/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int userId,
	         @Validated @RequestBody User userDetails) throws ResourceNotFoundException {
	    
	        return userDaoImpl.updateUser(userId,userDetails);
	    }

	    @DeleteMapping("/users/{id}")
	    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int userId)
	         throws ResourceNotFoundException {	    	
	        return userDaoImpl.deleteUser(userId);
	    }
	}


