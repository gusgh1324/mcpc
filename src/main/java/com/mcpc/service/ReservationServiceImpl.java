package com.mcpc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcpc.dto.ReMenuOrderDTO;
import com.mcpc.dto.ReservationDTO;
import com.mcpc.mapper.ReservationMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{
	private final ReservationMapper reservationMapper;

	@Override
	public void insert(ReservationDTO reservation, List<ReMenuOrderDTO> menuOrders) {
	    // 예약 정보 삽입
	    reservationMapper.insert(reservation);

	    // 메뉴 주문 정보 삽입
	    for (ReMenuOrderDTO menuOrder : menuOrders) {
	        menuOrder.setUNum(reservation.getUNum()); 
	        menuOrder.setRNum(reservation.getRNum());
	        reservationMapper.insertmenu(menuOrder);
	    }
	}

	@Override
	public List<ReservationDTO> list() {
		return reservationMapper.list();
	}
	@Override
	public List<ReMenuOrderDTO> listmenu() {
		return reservationMapper.listmenu();
	}

	@Override
	public Long max() {
		return reservationMapper.max();
	}
	
	
}
