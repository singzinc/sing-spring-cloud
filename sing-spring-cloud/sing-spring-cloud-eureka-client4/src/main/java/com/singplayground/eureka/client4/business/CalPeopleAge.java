package com.singplayground.eureka.client4.business;

import com.singplayground.eureka.client4.model.People;

public class CalPeopleAge {
	public People cal (People people){
		
		people.setAge(people.getAge() + 1 );
		
		return people;
	}
	

}
