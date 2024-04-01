package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.StoreMenuDTO;
import com.mcpc.service.StoreMenuService;
import com.mcpc.service.StoreService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/store/*")
@RequiredArgsConstructor
public class StoreMenuController {
	private final StoreMenuService storeMenuService;
	
	// 추가 폼
	@GetMapping("storeMenu")
	public String storeChoice(HttpSession session, Model model) {
	    Long sNum = (Long) session.getAttribute("sNum"); // 세션에서 sNum 값 가져오기
	    if (sNum != null) {
	        StoreDTO storeDTO = storeMenuService.getStoreBysNum(sNum); // sNum을 이용하여 StoreDTO를 가져옴
	        model.addAttribute("storeDTO", storeDTO); // StoreDTO를 모델에 추가
	    } else {
	        // sNum이 없는 경우에 대한 처리
	    }
	    return "store/storeMenu";
	}
    // 메뉴 추가
	@PostMapping("storeMenu")
	public String menuInsert(StoreMenuDTO menuDTO, Model model, HttpSession session) {
	    Long sNum = (Long) session.getAttribute("sNum"); // 세션에서 sNum 값 가져오기
	    if (sNum != null) {
	        StoreDTO storeDTO = storeMenuService.getStoreBysNum(sNum); // sNum을 이용하여 StoreDTO를 가져옴
	        menuDTO.setStoreDTO(storeDTO); // StoreDTO 설정
	        storeMenuService.menuInsert(menuDTO);
	        model.addAttribute("message", "메뉴가 추가되었습니다.");
	        return "redirect:/store/storeMenu"; // 추가 완료 후 다시 메뉴 추가 페이지로 리다이렉트합니다.
	    } else {
	        // sNum이 없는 경우에 대한 처리
	        // 예를 들어, 에러 메시지를 모델에 추가하고 다시 추가 폼 페이지로 이동할 수 있습니다.
	        model.addAttribute("error", "세션에 sNum이 없습니다. 다시 로그인해주세요.");
	        return "redirect:/store/storeLogin"; // 로그인 페이지로 리다이렉트
	    }
	}
}
