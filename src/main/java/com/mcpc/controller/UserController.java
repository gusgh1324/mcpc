package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcpc.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/login/*")
@RequiredArgsConstructor 
public class UserController {
	private final UserService userService;
	
	@GetMapping("join")
	public String join1() {
		return "/login/join";
	}


	// 로그인폼
	@GetMapping("login")
	public String login1() {
		return "/login/login";
	}


	//로그아웃
	@GetMapping("logout")
	public String logout1(HttpSession session) {
		session.invalidate();
		return "/login/login";
	}
}
