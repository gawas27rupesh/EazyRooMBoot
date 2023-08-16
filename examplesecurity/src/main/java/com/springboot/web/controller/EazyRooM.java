package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.constants.AppConstants;

@Controller
public class EazyRooM {
	
	@RequestMapping(AppConstants.HOME)
	public String home() {
		return AppConstants.INDEX;
	}	
}
