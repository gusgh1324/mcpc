package com.mcpc.service;

import org.springframework.stereotype.Service;

import com.mcpc.dto.StoreDTO;
import com.mcpc.mapper.StoreMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {
	private  final StoreMapper storeMapper;
	// 추가
	public void storeJoin(StoreDTO storeDTO) {
        storeMapper.storeJoin(storeDTO);
    }
}
