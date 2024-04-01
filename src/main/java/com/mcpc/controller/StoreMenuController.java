package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mcpc.dto.StoreMenuDTO;
import com.mcpc.service.StoreMenuService;
import com.mcpc.service.StoreService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/store/*")
@RequiredArgsConstructor
public class StoreMenuController {
	private final StoreMenuService storeMenuService;
	
	// 추가 폼
    @GetMapping("storeMenu")
    public String storeChoice() {
        return "store/storeMenu";
    }
    
	/*
	 * @PostMapping("storeMenu") public String menuInsert(StoreMenuDTO
	 * menuDTO, @RequestParam("imageFile") MultipartFile imageFile) { if (imageFile
	 * != null && !imageFile.isEmpty()) { String imageFilePath =
	 * saveImage(imageFile); // 이미지를 저장하고 파일 경로를 반환하는 메소드 호출
	 * menuDTO.setImageFile(imageFilePath); } storeMenuService.menuInsert(menuDTO);
	 * return "redirect:/store/storeMenu"; }
	 */
}
