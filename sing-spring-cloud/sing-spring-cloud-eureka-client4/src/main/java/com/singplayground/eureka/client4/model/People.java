package com.singplayground.eureka.client4.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import io.swagger.annotations.ApiModelProperty;

public class People {
	
	@JsonProperty(value ="namex",required = true)
	@JsonPropertyDescription("This is a description of the name property")
	@ApiModelProperty(notes = "The Name for people")
	private String name;
	@ApiModelProperty(notes = "The age for people")
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
