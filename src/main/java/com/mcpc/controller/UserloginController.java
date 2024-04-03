package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcpc.dto.UserDTO;
import com.mcpc.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/login/user/*")
public class UserloginController {
    private final UserService userService;
    
    @GetMapping("join")
    public String join() {
        return "/login/user/join";
    }
    
    @GetMapping("login")
    public String login() {
        return "/login/user/login";
    }
    
    @GetMapping("mypage")
    public String mypage() {
    	return "/login/user/mypage";
    }
    
    @PostMapping("join")
	public String join(UserDTO user) {
		userService.join(user);
		return "redirect:/login/user/login";
	}
    
    @PostMapping("login")
    public String login(Model model ,UserDTO user, HttpSession session) {
        UserDTO u = userService.loginCheck(user.getUId()); 
        if (u == null) {  // 회원이 아님
            model.addAttribute("errorMessage", "아이디 또는 비밀번호를 확인해주세요.");
            return "/login/user/login";
        }
        if (u.getUPw().equals(user.getUPw())) { // 회원(비번 맞음)
            session.setAttribute("user", u);
            return "redirect:/home";
        } else { //비밀번호 오류
        	model.addAttribute("errorMessage", "아이디 또는 비밀번호를 확인해주세요.");
            return "/login/user/login";
        }
    }

    //로그아웃
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
}
