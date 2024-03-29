package com.mcpc.service;

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
	public void insert(ReservationDTO reservation, ReMenuOrderDTO reMenuOrder) {
		reservationMapper.insert(reservation);
		reservationMapper.insertmenu(reMenuOrder);
		
	}
	
	
}
