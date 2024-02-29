package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	//////test
	@GetMapping("home2")
	public String home2() {
		return "home2";
	}
	@GetMapping("review")
	public String review() {
		return "review";
	}
	//////test
	
	
	
	
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("blog")
	public String blog() {
		return "blog";
	}
	
	@GetMapping("blog-details")
	public String blogDetails() {
		return "blog-details";
	}
	
}
