package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.StoreDetailDTO;
import com.mcpc.service.StoreDetailService;
import com.mcpc.service.StoreService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/store/*")
@RequiredArgsConstructor
public class StoreDetailController {
	private final StoreDetailService storeDetailService;
	
	@GetMapping("storeDetail")
    public String showStoreDetailForm() {
        return "store/storeDetail";
    }
	
	@PostMapping("storeDetail")
	public String saveStoreDetail(StoreDetailDTO storeDetailDTO, HttpSession session, RedirectAttributes redirectAttributes) {
	    // 세션에서 sId 가져오기
	    String sId = (String) session.getAttribute("sId");

	    // sId가 없으면 로그인 페이지로 리다이렉트
	    if (sId == null) {
	        return "redirect:/storelogin"; // 로그인 페이지 경로로 수정
	    }

	    // sId를 사용하여 데이터베이스에서 해당하는 데이터 가져오기
	    StoreDTO storeDTO = storeDetailService.findStoreById(sId);

	    // 가져온 데이터와 사용자가 입력한 정보를 함께 사용하여 새로운 정보 생성 또는 업데이트
	    storeDetailDTO.setStoreDTO(storeDTO);
	    storeDetailService.saveStoreDetail(storeDetailDTO);

	    redirectAttributes.addFlashAttribute("message", "상세 정보가 저장되었습니다.");
	    return "redirect:/home";
	}

}
