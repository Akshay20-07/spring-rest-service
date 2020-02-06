package com.example.restwebservices.bean.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restwebservices.bean.Exception.UserResourceNotFoundException;

/**
 * implementation of GET,POST,DELETE along with HATEOAS 
 * HATEOAS ---implemented using WebMvcLinkBuilder instead of ControllerLinkBuilder
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
	
/*	@GetMapping(path="/users/{id}")
	public EntityModel<User> retrieveSpecific(@PathVariable int id){
		User user=service.findOne(id);
		if(user==null){
			throw new UserResourceNotFoundException("invalid id"+ id);
		}
		//all-users-->"/users"
		//to retrieve all users using HATEOAS
		
		EntityModel<User> model = new EntityModel<>(user);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAll());
		model.add(linkTo.withRel("all-users"));
		return model;
	}*/
	
	@GetMapping(path="/users/{id}")
	public Resource<User> retrieveSpecific(@PathVariable int id){
		User user=service.findOne(id);
		if(user==null){
			throw new UserResourceNotFoundException("invalid id"+ id);
		}
		//all-users-->"/users"
		//to retrieve all users using HATEOAS
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAll());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	

	@PostMapping(path="/users")
	public ResponseEntity<Object> createUser(@Validated @RequestBody User user){
		User saved=service.save(user);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public boolean deleteSpecific(@PathVariable int id){
		boolean flag=service.remove(id);
		if(flag==false){
			throw new UserResourceNotFoundException("invalid id"+ id);
		}
		return flag;
	}
	
	

}
