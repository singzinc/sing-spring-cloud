package com.singplayground.eureka.client4.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.singplayground.eureka.client4.business.CalPeopleAge;
import com.singplayground.eureka.client4.model.People;

@RestController
public class TestController {
	 @RequestMapping("/info")
	    public String info() {
	        return "the message from client 4";
	    }
	    
	 @RequestMapping(method = RequestMethod.POST, value = "/helloWorld")
	 public People helloWorld(@RequestBody  People people) {
	    	System.out.println("xxx2");
	    	System.out.println("name : " + people.getName());
	    	System.out.println("age : " + people.getAge());
	    	
	    	CalPeopleAge calPeopleAge = new CalPeopleAge();
	    	people = calPeopleAge.cal(people);
	    	//people.setAge(people.getAge() + 1);
	    	System.out.println("just return the the information ") ;
	        return people;
	 }
	 
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/helloWorld/{age}")
	 public People helloWorld2(@PathVariable("age") int age) {
	    	People people = new People();
	    	people.setAge(age);
	        return people;
	 }

}
