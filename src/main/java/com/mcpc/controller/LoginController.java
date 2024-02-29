package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcpc.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor 
public class LoginController {
	private final UserService userService;
	
	@GetMapping("join")
	public String join() {
		return "/user/join";
	}


	// 로그인폼
	@GetMapping("login")
	public String login() {
		return "/user/login";
	}


	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/user/login";
	}
}
