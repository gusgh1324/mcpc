package com.mcpc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcpc.mapper.ReservationMapper;
import com.mcpc.model.MenuOrder;
import com.mcpc.model.Reservation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationMapper reservationMapper;

    public List<Reservation> insert(Reservation reservation, MenuOrder[] menuOrders) {
        // 예약 정보 삽입
        reservationMapper.reservationInsert(reservation);

        // 예약의 ID 가져오기
        Long reservationId = reservationMapper.getLastInsertId();

        // 메뉴 주문 삽입
        for (MenuOrder menuOrder : menuOrders) {
            reservationMapper.menuOrderInsert(menuOrder, reservationId);
        }
        
        // 모든 예약 정보 반환
        return reservationMapper.getAllReservations();
    }


}
