package com.mcpc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcpc.dto.ReMenuOrderDTO;
import com.mcpc.dto.ReservationDTO;
import com.mcpc.dto.UserDTO;
import com.mcpc.service.ReservationService;

import jakarta.servlet.http.HttpSession;
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

	@PostMapping("form")
	public String formInsert(ReservationDTO reservation, @RequestParam List<String> orderMenu, @RequestParam List<Integer> menuCount) {
	    List<ReMenuOrderDTO> menuOrders = new ArrayList<>();
	    for (int i = 0; i < orderMenu.size(); i++) {
	        ReMenuOrderDTO reMenuOrder = new ReMenuOrderDTO();
	        reMenuOrder.setOrderMenu(orderMenu.get(i));
	        reMenuOrder.setMenuCount(menuCount.get(i));
	        menuOrders.add(reMenuOrder);
	    }

	    reservationService.insert(reservation, menuOrders);
	    
	    return "/reservation/thankCustomer";
	}

	@GetMapping("/form")
	public String form(Model model, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login/user/login";
		}

		model.addAttribute("reservation", new ReservationDTO());
		return "reservation/form";
	}

	@GetMapping("list")
	public String list(Model model, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login/user/login";
		}

		model.addAttribute("reser", reservationService.list());
		model.addAttribute("reme", reservationService.listmenu());
		return "/reservation/list";
	}

	@GetMapping("order")
	public String order(Model model, HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login/user/login";
		}

		model.addAttribute("reser", reservationService.list());
		model.addAttribute("reme", reservationService.listmenu());
		model.addAttribute("remax", reservationService.max());

		return "/reservation/order";
	}

	@GetMapping("thankCustomer")
	public String thankCustomer() {
		return "/reservation/thankCustomer";
	}

}
