package com.mcpc.service;

import org.springframework.stereotype.Service;

import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.StoreDetailDTO;
import com.mcpc.mapper.StoreDetailMapper;
import com.mcpc.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreDetailService {
    private final StoreDetailMapper storeDetailMapper;
    private final StoreRepository storeRepository;
    
    public void saveStoreDetail(StoreDetailDTO storeDetailDTO) {
        storeDetailMapper.saveStoreDetail(storeDetailDTO);
    }
    
    public StoreDetailDTO getStoreDetailBySnum(Long sNum) {
        // snum을 기반으로 StoreDetailDTO와 StoreDTO를 조인하여 결과를 반환하는 메서드
        StoreDTO storeDTO = storeRepository.findBysNum(sNum); // 예시로 추가한 메서드
        // storeDTO에서 필요한 정보를 가져와서 StoreDetailDTO에 설정
        StoreDetailDTO storeDetailDTO = new StoreDetailDTO();
        storeDetailDTO.setStoreDTO(storeDTO);
        return storeDetailDTO;
    }
    
    public StoreDTO findStoreById(String sId) {
        return storeRepository.findBysId(sId);
    }
}
