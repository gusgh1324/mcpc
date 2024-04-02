package com.mcpc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.StoreDetailDTO;
import com.mcpc.dto.StoreMenuDTO;
import com.mcpc.mapper.StoreListMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreListServiceImpl implements StoreListService{
	private final StoreListMapper storeListMapper;
	
	public List<StoreDetailDTO> list(){
		return storeListMapper.list();
	}
	public List<StoreMenuDTO> list2(){
		return storeListMapper.list2();
		
	}
	public List<StoreDTO> list3(){
		return storeListMapper.list3();
		
	}
	@Override
	public List<StoreMenuDTO> listDetail(Long sId) {
		return storeListMapper.listDetail(sId);
	}

}
