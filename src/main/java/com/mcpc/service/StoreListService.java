package com.mcpc.service;

import java.util.List;

import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.StoreDetailDTO;
import com.mcpc.dto.StoreMenuDTO;

public interface StoreListService {
	public List<StoreDetailDTO> list();
	public List<StoreMenuDTO> list2();
	public List<StoreMenuDTO> listDetail(Long sId);
	public List<StoreDTO> list3();

}
