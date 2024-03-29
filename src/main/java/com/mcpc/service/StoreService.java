package com.mcpc.service;


import org.springframework.stereotype.Service;

import com.mcpc.dto.StoreDTO;
import com.mcpc.mapper.StoreMapper;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
	private  final StoreMapper storeMapper;
	// 추가
	public void storeJoin(StoreDTO storeDTO) {
        storeMapper.storeJoin(storeDTO);
    }
	// 아이디로 가게 정보 조회
    public StoreDTO findStoreById(String sId) {
        List<StoreDTO> storeList = storeMapper.findStoreById(sId); // StoreDTO 객체의 목록을 가져옵니다.
        if (storeList != null && !storeList.isEmpty()) {
            // 목록이 비어 있지 않으면, 첫 번째 요소를 반환합니다.
            return storeList.get(0);
        } else {
            // 목록이 비어 있는 경우, null을 반환합니다.
            return null;
        }
    }

    // 로그인 검증 및 세션 설정
    public boolean authenticate(StoreDTO storeDTO, HttpSession session) {
        // 아이디로 가게 정보를 조회합니다.
        StoreDTO store = findStoreById(storeDTO.getSId());

        // 조회된 가게 정보가 없거나 비밀번호가 일치하지 않으면 로그인 실패를 반환합니다.
        if (store != null && store.getSPw().equals(storeDTO.getSPw())) {
            // 로그인 성공 시 세션에 인증 정보 설정합니다.
            session.setAttribute("authenticatedStore", true);
            session.setAttribute("sId", store.getSId());
            return true; // 인증 성공
        } else {
            return false; // 인증 실패
        }
    }

    // 로그아웃 시 세션 초기화
    public void logout(HttpSession session) {
        session.removeAttribute("authenticatedStore");
        session.removeAttribute("sId");
    }
}
