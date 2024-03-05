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
import com.mcpc.dto.StoreDetailDTO;
import com.mcpc.service.StoreService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/store/*")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    
	//사업자를 누르면 storeChoice.html로 이동
	@GetMapping("storeChoice")
	public String storeChoice() {
		return "store/storeChoice";
	}

	// 회원가입 페이지로 이동
	@GetMapping("storeJoin")
	public String joinForm(Model model) {
	    model.addAttribute("storeDTO", new StoreDTO());
	    return "store/storeJoin";
	}

    // 회원가입 처리
    @PostMapping("storeJoin")
    public String join(StoreDTO storeDTO, RedirectAttributes redirectAttributes) {
        if (!storeDTO.isValid()) {
            return "store/storeJoin"; // 유효성 검사에 실패하면 다시 회원가입 페이지로 이동
        }
        try {
            storeService.storeJoin(storeDTO);
            redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다. 로그인해주세요.");
            return "redirect:/store/storeLogin"; // 회원가입 성공 후 로그인 페이지로 이동
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // 오류 페이지로 이동 또는 오류 메시지 표시
        }
    }

    // 로그인 페이지로 이동
    @GetMapping("storeLogin")
    public String loginForm() {
        return "store/storeLogin";
    }

    // 로그인 처리
    @PostMapping("storeLogin")
    public String login(StoreDTO storeDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        // 여기서는 storeName을 세션에 저장합니다.
        String storeName = storeDTO.getStoreName(); // 가게 이름을 로그인 아이디로 가정
        session.setAttribute("storeName", storeName); // storeName을 세션에 저장
        return "redirect:/store/home"; // 로그인 성공 후 home 페이지로 이동
    }

    // home 페이지로 이동
    @GetMapping("home")
    public String home(HttpSession session, Model model) {
        // 세션에서 storeName을 가져와서 모델에 추가
        String storeName = (String) session.getAttribute("storeName");
        model.addAttribute("storeName", storeName);
        return "home";
    }

    // 메뉴 추가 페이지로 이동
    @GetMapping("storeDetail")
    public String storeDetail(HttpSession session, Model model) {
        String storeName = (String) session.getAttribute("storeName");
        model.addAttribute("storeName", storeName);
        model.addAttribute("storeDetailDTO", new StoreDetailDTO());
        return "store/storeDetail";
    }

    // 메뉴 추가 처리
    @PostMapping("storeDetail")
    public String addStoreDetail(HttpSession session, StoreDetailDTO storeDetailDTO, @RequestParam("imageFile") MultipartFile imageFile, RedirectAttributes redirectAttributes) {
        String storeName = (String ) session.getAttribute("storeName");
        try {
            byte[] imageData = imageFile.getBytes();
            storeDetailDTO.setImage(new String(imageData)); // 이미지 처리
            redirectAttributes.addFlashAttribute("message", "메뉴가 성공적으로 추가되었습니다.");
            return "redirect:/store/home"; // 메뉴 추가 후 home 페이지로 이동
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; // 오류 페이지로 이동 또는 오류 메시지 표시
        }
    }

}
