package com.example.restwebservices.bean.filter;

import java.util.Collection;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

	@GetMapping(path="/filter")
	public Sample someValue(){
		return new Sample("Hello","World","you");
	}
	
}
