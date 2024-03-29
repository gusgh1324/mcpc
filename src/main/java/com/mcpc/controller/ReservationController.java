package com.mcpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mcpc.dto.ReMenuOrderDTO;
import com.mcpc.dto.ReservationDTO;
import com.mcpc.service.ReservationService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/reservation/*")
public class ReservationController {
	private final ReservationService reservationService;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
	 @GetMapping("/form")
	    public String form(Model model) {
	        model.addAttribute("reservation", new ReservationDTO());
	        return "reservation/form";
	    }
	 
	@PostMapping("form")
	public String formInsert(ReservationDTO reservation, ReMenuOrderDTO reMenuOrder) {
		reservationService.insert(reservation, reMenuOrder);
		return "/reservation/thankCustomer";
	}
	
	
	
	
	
	
	
	
	@GetMapping("list")
	public String list() {
		return "/reservation/list";
	}
	@GetMapping("order")
	public String order() {
//		 if (reservations.isEmpty()) {
//	            return "reservation/reorder"; 
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
