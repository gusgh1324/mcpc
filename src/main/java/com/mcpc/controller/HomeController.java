package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	

	@GetMapping("review")
	public String review() {
		return "review";
	}
	//////test2
		
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("home")
	public String home2() {
		return "home";
	}
	
	
}
