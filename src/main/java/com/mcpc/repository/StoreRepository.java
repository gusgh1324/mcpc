package com.mcpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mcpc.dto.StoreDTO;

@Repository
public interface StoreRepository extends JpaRepository<StoreDTO, Long> {
    // 가게 이름을 통해 사용자를 찾는 메서드 추가
	StoreDTO findByStoreName(String storeName);
}
