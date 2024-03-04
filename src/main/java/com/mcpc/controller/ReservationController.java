package com.mcpc.controller;

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
    public String form(Reservation reservation, @RequestParam("orderMenu") String[] orderMenus,
            @RequestParam("menuCount") int[] menuCounts, Model model) {
        MenuOrder[] menuOrders = new MenuOrder[orderMenus.length];
        for (int i = 0; i < orderMenus.length; i++) {
            MenuOrder menuOrder = new MenuOrder();
            menuOrder.setMenuName(orderMenus[i]);
            menuOrder.setMenuCount(menuCounts[i]);
            menuOrder.setReservation(reservation);
            menuOrders[i] = menuOrder;
        }

        // 예약 서비스에서 예약 정보를 추가하고 반환값을 사용하여 모델에 추가
        Reservation savedReservation = reservationService.insert(reservation, menuOrders);
        model.addAttribute("reservation", savedReservation);

        return "reservation/order";
    }

    // 영수증 확인
    @GetMapping("/order")
    public String order(Model model) {
        // 예약 서비스에서 예약 목록을 가져와 모델에 추가
        model.addAttribute("reservation", reservationService.list());
        return "reservation/order";
    }
}
