package com.mcpc.service;

import org.springframework.stereotype.Service;

import com.mcpc.dto.StoreDetailDTO;
import com.mcpc.mapper.StoreDetailMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreDetailService {
    private final StoreDetailMapper storeDetailMapper;
    
    public void saveStoreDetail(StoreDetailDTO storeDetailDTO) {
        storeDetailMapper.saveStoreDetail(storeDetailDTO);
    }
   
   
}
