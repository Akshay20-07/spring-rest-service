package com.example.restwebservices.bean.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//Controller
/**
 * @author ezaksch
 *
 */
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource msgSrc;
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

	/**
	 * To provide International implementation of a Request
	 * @param locale
	 * @return
	 */
/*	@GetMapping(path="/hello-goodmorning")
	public String morningInterNational(@RequestHeader(name="Accept-Language",required=false) Locale locale){
		return msgSrc.getMessage("good.morning.message", null, locale);
	}*/
	@GetMapping(path="/hello-goodmorning")
	public String morningInterNational(){
		return msgSrc.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

}
