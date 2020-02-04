package com.example.restwebservices.bean.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
