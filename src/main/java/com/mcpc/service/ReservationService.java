package com.mcpc.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mcpc.mapper.ReservationMapper;
import com.mcpc.model.MenuOrder;
import com.mcpc.model.Reservation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {
	private  final ReservationMapper reservationMapper;
	// 추가
		public void insert(Reservation reservation, MenuOrder[] menuOrders) {
			reservationMapper.reservationInsert(reservation);
			reservationMapper.menuOrderInsert(menuOrders);
	    }
			
}
