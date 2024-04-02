package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.UserDTO;
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
    public String loginForm(HttpSession session, Model model) {
        // 세션에서 인증 정보를 가져와서 로그인 여부를 확인
        Boolean authenticatedStore = (Boolean) session.getAttribute("authenticatedStore");
        
        if (authenticatedStore != null && authenticatedStore) {
            // 이미 로그인된 경우 로그아웃 버튼을 보여줌
            model.addAttribute("loggedIn", true);
        }
        return "store/storeLogin";
    }

	@PostMapping("storeLogin")
	public String login(StoreDTO storeDTO, HttpSession session, RedirectAttributes redirectAttributes) {
	    if (storeService.authenticate(storeDTO, session)) {
	        // 로그인 성공 시 storeChoice 페이지로 리다이렉트
	        StoreDTO sId = storeService.findStoreById(storeDTO.getSId()); // 로그인 과정을 통해 얻은 sId
	        session.setAttribute("sId", sId); // 세션에 sId 저장
	        return "redirect:/store/storeChoice";
	    } else {
	        // 로그인 실패 시 로그인 페이지로 리다이렉트하고 에러 메시지 전달
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
    
	// HttpSession 객체를 이용하여 세션 값 확인
	@GetMapping("/checkSession")
	public String checkSession(HttpSession session) {
	    String sId = (String) session.getAttribute("sId");
	    if (sId != null) {
	        // 세션에 sId가 존재하는 경우
	        System.out.println("세션에 sId가 올바르게 설정되었습니다: " + sId);
	    } else {
	        // 세션에 sId가 존재하지 않는 경우
	        System.out.println("세션에 sId가 설정되지 않았거나 null입니다.");
	    }
	    return "redirect:/home"; // 확인 후 홈 페이지로 리다이렉트하거나 적절한 경로로 리다이렉트
	}
	
	@PostMapping("login")
	public String login(HttpSession session, StoreDTO store) {
	    session.setAttribute("sId", store);
	    // 로그인이 성공적으로 처리되었으므로 다른 작업을 수행하거나 페이지를 이동합니다.
	    return "redirect:/home";
	}

}
