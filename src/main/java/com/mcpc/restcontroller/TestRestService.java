package com.mcpc.restcontroller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcpc.dto.ReMenuOrderDTO;
import com.mcpc.dto.ReservationDTO;
import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.StoreDetailDTO;
import com.mcpc.dto.StoreMenuDTO;
import com.mcpc.dto.UserDTO;

import lombok.RequiredArgsConstructor;

public interface TestRestService {
	public List<UserDTO> viewUser();
	public List<StoreDTO> viewStore();
	public List<StoreDetailDTO> viewDetail();
	public List<StoreMenuDTO> viewMenu();
	public List<ReservationDTO> viewReservation();
	public List<ReMenuOrderDTO> viewReMenuOrder();
}
