package com.example.restwebservices.bean.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author ezaksch
 *
 */

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	
	/**
	 * To retrieve All users
	 * @return
	 */
	@GetMapping(path="/users")
	public List<User> retrieveAll(){
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User retrieveSpecific(@PathVariable int id){
		return service.findOne(id);
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User saved=service.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
