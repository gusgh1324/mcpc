package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcpc.service.StoreService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/store/*")
@RequiredArgsConstructor
public class StoreMenuController {
	
	@GetMapping("storeMenu")
	public String storeChoice() {
		return "store/storeMenu";
	}
}
