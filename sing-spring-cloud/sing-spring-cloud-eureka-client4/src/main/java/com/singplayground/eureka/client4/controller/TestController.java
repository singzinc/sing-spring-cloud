package com.singplayground.eureka.client4.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.singplayground.eureka.client4.business.CalPeopleAge;
import com.singplayground.eureka.client4.model.People;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
@RestController
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	 @RequestMapping("/info")
	    public String info() {
	        return "the message from client 4";
	    }
	 */
	 
	 @ApiOperation(value = "Test hello world ", notes = " this is notes " )
	 @ApiImplicitParams(
		      @ApiImplicitParam(name="header1", value="this is api implicit param ") 
		  )
	 /*
	 @ApiResponses({
	        @ApiResponse(code = 200, message = "the lit of users", response = People.class),
	        @ApiResponse(code = 400, message = "400 error message")
	})
	*/
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
	
	 public People helloWorld2(@ApiParam("This is age description") @PathVariable("age") int age ,@RequestHeader(name = "remote_addr") String remoteAddress) {
		 logger.debug("test the logging");
		 logger.debug("This is a debug message");
	     logger.info("This is an info message");
	     logger.warn("This is a warn message");
	     logger.error("This is an error message");
	     System.out.println(remoteAddress);
		 
		 
		 
	    	People people = new People();
	    	people.setAge(age);
	        return people;
	 }

}
