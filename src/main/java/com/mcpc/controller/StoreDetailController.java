package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String saveStoreDetail(StoreDetailDTO storeDetailDTO, HttpSession session) {
	    storeDetailService.saveStoreDetail(storeDetailDTO);
	 
	    return "redirect:/home";
	}

	
}
