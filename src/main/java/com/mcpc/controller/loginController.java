package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login/*")
public class loginController {
	
	@GetMapping("join")
	public String showJoinForm(Model model) {
		return "login/join";
	}
	@GetMapping("login")
	public String showLoginForm(Model model) {
		return "login/login";
	}
}
