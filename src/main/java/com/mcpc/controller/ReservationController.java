package com.mcpc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcpc.model.MenuOrder;
import com.mcpc.model.Reservation;
import com.mcpc.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // 예약하러가기
    @GetMapping("/form")
    public String form() {
        return "reservation/form";
    }

    // 예약하기
    @PostMapping("/form")
    public String form(Reservation reservation, @RequestParam("orderMenu") List<String> orderMenus,
            @RequestParam("menuCount") List<Integer> menuCounts, Model model) {
        List<MenuOrder> menuOrders = new ArrayList<>();
        for (int i = 0; i < orderMenus.size(); i++) {
            MenuOrder menuOrder = new MenuOrder();
            menuOrder.setMenuName(orderMenus.get(i));
            menuOrder.setMenuCount(menuCounts.get(i));
            menuOrder.setReservation(reservation);
            menuOrders.add(menuOrder);
        }
        
        reservationService.insert(reservation, menuOrders);

        return "reservation/thankCustomer";
    }


    // 영수증 확인
    @GetMapping("/order")
    public String order(Model model) {
        // 예약 서비스에서 예약 목록을 가져와 모델에 추가
        model.addAttribute("reservation", reservationService.list());
        model.addAttribute("menuOrders", reservationService.list2());
        return "reservation/order";
    }
}
