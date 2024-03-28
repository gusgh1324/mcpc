package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/reservation/*")
public class ReservationController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("form")
	public String form() {
		return "/reservation/form";
	}
	@GetMapping("list")
	public String list() {
		return "/reservation/list";
	}
	@GetMapping("order")
	public String order() {
		return "/reservation/order";
	}
	@GetMapping("reorder")
	public String reorder() {
		return "/reservation/reorder";
	}
	@GetMapping("thankCustomer")
	public String thankCustomer() {
		return "/reservation/thankCustomer";
	}
	
}
