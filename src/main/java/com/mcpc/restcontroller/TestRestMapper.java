package com.mcpc.restcontroller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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

@Mapper
public interface TestRestMapper {
	
	@Select("select * from user")
	public List<UserDTO> viewUser();
	
	@Select("select * from store")
	public List<StoreDTO> viewStore();
	
	@Select("select * from store_detail")
	public List<StoreDetailDTO> viewDetail();
	
	@Select("select * from store_menu")
	public List<StoreMenuDTO> viewMenu();
	
	@Select("select * from reservation")
	public List<ReservationDTO> viewReservation();
	
	@Select("select * from remenuorder")
	public List<ReMenuOrderDTO> viewReMenuOrder();
}
