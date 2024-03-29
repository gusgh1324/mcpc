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
	    // StoreDTO를 가져와서 StoreDetailDTO에 설정
	    String sId = (String) session.getAttribute("sId");
	    StoreDTO storeDTO = storeDetailService.findStoreById(sId);
	    storeDetailDTO.setStoreDTO(storeDTO);
	    
	    // StoreDetailDTO를 저장
	    storeDetailService.saveStoreDetail(storeDetailDTO);
	    
	    redirectAttributes.addFlashAttribute("message", "상세 정보가 저장되었습니다.");
	    return "redirect:/home";
	}
}
