package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    
	@GetMapping("storeChoice")
	public String storeChoice() {
		return "store/storeChoice";
	}

	@GetMapping("storeJoin")
	public String joinForm(Model model) {
	    model.addAttribute("storeDTO", new StoreDTO());
	    return "store/storeJoin";
	}

	@PostMapping("storeJoin")
	public String join(StoreDTO storeDTO, RedirectAttributes redirectAttributes) {
	    if (storeDTO.getSId().isEmpty() || storeDTO.getSPw().isEmpty()) {
	        redirectAttributes.addFlashAttribute("error", "빈 칸을 모두 입력해주세요.");
	        return "redirect:/store/storeJoin";
	    }
	    else {
	        storeService.storeJoin(storeDTO);
	        redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다. 로그인해주세요.");
	        return "redirect:/store/storeLogin"; 
	    }
	}

	@GetMapping("storeLogin")
    public String loginForm() {
        return "store/storeLogin";
    }

    @PostMapping("storeLogin")
    public String login(StoreDTO storeDTO, HttpSession session, RedirectAttributes redirectAttributes) {
    	if (storeService.authenticate(storeDTO)) {
    	    // 로그인 성공
    	    session.setAttribute("authenticatedStore", true);
    	    session.setAttribute("sId", storeDTO.getSId());
    	    return "redirect:/store/home";
    	} else {
            // 로그인 실패
            redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/store/storeLogin";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("authenticatedStore");
        session.removeAttribute("sId");
        return "redirect:/store/storeLogin";
    }

    @GetMapping("home")
    public String home(Model model, HttpSession session) {
        // 로그인한 사용자의 정보가 있는지 확인
        Boolean authenticatedStore = (Boolean) session.getAttribute("authenticatedStore");
        String sId = (String) session.getAttribute("sId");
        
        if (authenticatedStore != null && authenticatedStore) {
            StoreDTO storeInfo = storeService.findStoreById(sId);
            model.addAttribute("storeInfo", storeInfo);
            return "home"; // 홈 페이지로 이동
        } else {
            // 로그인하지 않은 사용자일 경우 로그인 페이지로 리다이렉트
            return "redirect:/store/storeLogin";
        }
    }

}
