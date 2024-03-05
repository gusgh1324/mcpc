package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcpc.dto.UserDTO;
import com.mcpc.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor 
public class UserController {
	private final UserService userService;
	
	@GetMapping("join")
	public String showJoinForm(Model model) {
		model.addAttribute("user", new UserDTO());
		return "user/join";
	}

	@PostMapping("join")
	public String submitJoinForm(@ModelAttribute("user") UserDTO user, BindingResult result) {
		if (result.hasErrors()) {
			// 유효성 검사 실패시 처리
			return "user/join";
		}

		userService.join(user);
		return "redirect:/user/login"; // 회원가입 후 로그인 페이지로 이동
	}

	@GetMapping("login")
	public String loginForm() {
		return "user/login"; // login.html을 찾아서 반환합니다.
	}

	@PostMapping("login")
	public String login(@RequestParam("userId") String userId,
	                    @RequestParam("userPassword") String userPassword,
	                    HttpSession session) {
	    // 로그인 로직 수행
	    UserDTO user = userService.login(userId, userPassword);
	    if (user != null) {
	        session.setAttribute("user", user);
	        return "redirect:/user/home"; // 로그인 성공 시 홈 페이지로 리다이렉트합니다.
	    } else {
	        return "user/login"; // 로그인 실패 시 다시 로그인 페이지로 이동합니다.
	    }
	}

	// 홈페이지로 이동
	@GetMapping("home")
	public String home() {
		return "home";
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/user/login"; // 로그아웃 후 로그인 페이지로 이동
	}
}
