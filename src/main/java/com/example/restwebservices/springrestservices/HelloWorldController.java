package com.example.restwebservices.springrestservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.restwebservices.bean.HelloBean;

//Controller
/**
 * @author ezaksch
 *
 */
@RestController
public class HelloWorldController {
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello")
	/**
	 * simple example for the rest response
	 * @return
	 */
	@GetMapping(path="/hello")
	public String hello(){
		return "Hello World";
	}
	
	
	/**
	 * To return a json format of a bean
	 * @return
	 */
	@GetMapping(path="/hello-bean")
	public HelloBean helloBean(){
		return new HelloBean("Hello World");
	}

	
	/**
	 * To fetch name from the url we use {name}
	 * @param name=akshay //hello-bean/path/akshay
	 * @return
	 */
	@GetMapping(path="/hello-bean/path/{name}")
	public HelloBean helloBean(@PathVariable String name){
		return new HelloBean(String.format("Hello World,%s",name));
	}


}
