package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcpc.service.StoreDetailService;
import com.mcpc.service.StoreListService;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class StoreListController {
	private final StoreListService storeListService;

	
	@GetMapping("home2")
	public String storeList(Model model) {
		model.addAttribute("storeD",storeListService.list());
		model.addAttribute("storeM",storeListService.list2());
		model.addAttribute("store",storeListService.list3());
		return "home2";
	}
}
