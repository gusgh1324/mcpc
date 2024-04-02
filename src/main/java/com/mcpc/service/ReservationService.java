package com.mcpc.service;

import java.util.List;

import com.mcpc.dto.ReMenuOrderDTO;
import com.mcpc.dto.ReservationDTO;

public interface ReservationService {
	public void insert(ReservationDTO reservation, List<ReMenuOrderDTO> menuOrders);
	
	public List<ReservationDTO> list();
	public List<ReMenuOrderDTO> listmenu();
	public Long max(Long uNum);
	
	List<ReservationDTO> getReservationsByUNum(Long uNum);

}
