package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/reservation/*")
public class ReservationController {
	
	@GetMapping("order")
	public String order() {
		return "/reservation/order";
	}
	@GetMapping("form")
	public String form() {
		return "/reservation/form";
	}
	@PostMapping("form")
	public String form(Model model) {
		return "/reservation/thankCustomer";
	}
	@GetMapping("thankCustomer")
	public String thankCustomer() {
		return "/reservation/thankCustomer";
	}
	
}
