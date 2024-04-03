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

@Service
@RequiredArgsConstructor
public class TestRestServiceImpl implements TestRestService{
	private final TestRestMapper testRestMapper;

	@Override
	public List<UserDTO> viewUser() {
		return testRestMapper.viewUser();
	}

	@Override
	public List<StoreDTO> viewStore() {
		return testRestMapper.viewStore();
	}

	@Override
	public List<StoreDetailDTO> viewDetail() {
		return testRestMapper.viewDetail();
	}

	@Override
	public List<StoreMenuDTO> viewMenu() {
		return testRestMapper.viewMenu();
	}

	@Override
	public List<ReservationDTO> viewReservation() {
		return testRestMapper.viewReservation();
	}

	@Override
	public List<ReMenuOrderDTO> viewReMenuOrder() {
		return testRestMapper.viewReMenuOrder();
	}
	
}
