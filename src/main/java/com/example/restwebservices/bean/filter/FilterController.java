package com.example.restwebservices.bean.filter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	
	
	/**
	 * For Static Filtering
	 * @return
	 */
	@GetMapping(path="/filter")
	public Sample staticValue(){
		return new Sample("Hello","World","you");
	}
	
	@GetMapping(path="/filter-list")
	public List<Sample> staticList(){
		Sample s1=new Sample("value1", "value2", "value3");
		Sample s2=new Sample("value12", "value22", "value32");
		List<Sample> list = new ArrayList<Sample>();
		list.add(s1);
		list.add(s2);
		return list;
	}
	
	@GetMapping(path="/dynamic-filter")
	public MappingJacksonValue dynamicValue(){
		Sample sample=new Sample("Hello","World","you");
		
		SimpleBeanPropertyFilter propFilter=SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		
		FilterProvider simpleFilter=new SimpleFilterProvider().addFilter("Dynamic Filter", propFilter);
		
		MappingJacksonValue mapping=new MappingJacksonValue(sample);
		mapping.setFilters(simpleFilter);
		return mapping;
	}
	
	@GetMapping(path="/dynamic-filter-list")
	public List<Sample> dynamicList(){
		Sample s1=new Sample("value1", "value2", "value3");
		Sample s2=new Sample("value12", "value22", "value32");
		List<Sample> list = new ArrayList<Sample>();
		list.add(s1);
		list.add(s2);
		return list;
	}
	
}
