package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    @PostMapping("join")
	@ResponseBody
	public String join(@RequestBody UserDTO user) {
		String cnt = userService.idCheck(user.getUId());
		if (cnt != null)
			return "fail"; // 아이디 존재
		userService.join(user);
		return "success";
	}
    
    @PostMapping("login")
    @ResponseBody
    public String login(@RequestBody UserDTO user, HttpSession session) {
        UserDTO u = userService.loginCheck(user.getUId()); // 변경된 부분
        if(u == null) {  //회원이 아님
            return "no";
        }
        if (u.getUPw().equals(user.getUPw())) { // 회원(비번 맞음)
            session.setAttribute("user", u);
            return "success";
        } else { //비밀번호 오류
            return "fail";
        }
    }

    //로그아웃
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "/login/user/login";
    }
}
