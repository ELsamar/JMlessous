package com.jaune.JMlessous.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import com.jaune.JMlessous.exception.ResourceNotFoundException;
import com.jaune.JMlessous.model.User;
import com.jaune.JMlessous.repository.UserRepository;

@Repository
public class UserDaoImpl {
	@Autowired
    private JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate template;
	@Autowired
	private UserRepository userRepository;
	
	@SuppressWarnings("deprecation")
	public User findByUser(String username,String password) {
		 return jdbcTemplate.queryForObject
		          ("SELECT * FROM user WHERE username = ? AND password = ?",
		          new Object[] { username, password }, 
		          new BeanPropertyRowMapper<User>(User.class));  

}


	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	

	    public ResponseEntity<User> getUserById(int userId)
	        throws ResourceNotFoundException {
	    	User user = userRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
	        return ResponseEntity.ok().body(user);
	    }
	    
	 
	    public User createUser( User user) {
	        return userRepository.save(user);
	    }

	
	    public ResponseEntity<User> updateUser(int userId, User userDetails) throws ResourceNotFoundException {
	    	User user = userRepository.findById(userId)
	        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	    	user.setMail(userDetails.getMail());
	    	user.setUsername(userDetails.getUsername());
	    	user.setPassword(userDetails.getPassword());
	        final User updateduser = userRepository.save(user);
	        return ResponseEntity.ok(updateduser);
	    }

	 
	    public Map<String, Boolean> deleteUser(int userId)
	         throws ResourceNotFoundException {
	    	User user = userRepository.findById(userId)
	       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        userRepository.delete(user);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
