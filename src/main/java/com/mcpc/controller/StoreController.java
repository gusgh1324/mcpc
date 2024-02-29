package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mcpc.dto.StoreDTO;
import com.mcpc.service.StoreService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/store/*")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    
    @GetMapping("storeJoin")
    public String joinForm() {
        return "store/storeJoin";
    }
    
    @PostMapping("storeJoin")
    public String join(StoreDTO storeDTO, RedirectAttributes redirectAttributes) {
        try {
            storeService.storeJoin(storeDTO);
            redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다. 로그인해주세요.");
            return "redirect:/store/storeLogin"; // 회원가입 성공 후 로그인 페이지로 이동
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // 오류 페이지로 이동 또는 오류 메시지 표시
        }
    }
    
    // 로그인 페이지로 이동하는 핸들러 추가
    @GetMapping("storeLogin")
    public String loginForm() {
        return "store/storeLogin";
    }
    
    // 로그인 처리
    @PostMapping("storeLogin")
    public String login(StoreDTO storeDTO, RedirectAttributes redirectAttributes) {
        // 로그인 처리를 여기에 추가
        // storeService.login(storeDTO); 등등
        // 로그인이 성공하면 어떻게 처리할지 결정
        return "redirect:/store/home"; // 로그인 성공 후 홈페이지로 리다이렉트
    }
    
    // 홈페이지로 이동
    @GetMapping("home")
    public String home() {
        return "home";
    }

}
