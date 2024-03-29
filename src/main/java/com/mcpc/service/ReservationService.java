package com.mcpc.service;

import com.mcpc.dto.ReMenuOrderDTO;
import com.mcpc.dto.ReservationDTO;

public interface ReservationService {
	public void insert(ReservationDTO reservation, ReMenuOrderDTO reMenuOrder);

}
