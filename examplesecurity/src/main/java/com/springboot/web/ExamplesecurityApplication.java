package com.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.springboot.web.controller,com.springboot.web.entities,com.springboot.web.repository,com.springboot.web.service,com.springboot.web.serviceImpl"})
public class ExamplesecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamplesecurityApplication.class, args);
	}

}