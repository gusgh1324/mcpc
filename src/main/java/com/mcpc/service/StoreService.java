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
    // 아이디로 가게 정보 조회
    public StoreDTO findStoreById(String sid) {
        return storeMapper.findStoreById(sid);
    }

    // 로그인 검증
    public boolean authenticate(StoreDTO storeDTO) {
        // 아이디로 가게 정보를 조회
        StoreDTO store = findStoreById(storeDTO.getSId());

        // 조회된 가게 정보가 없거나 비밀번호가 일치하지 않으면 로그인 실패를 반환
        return store != null && store.getSPw().equals(storeDTO.getSPw());
    }
}
