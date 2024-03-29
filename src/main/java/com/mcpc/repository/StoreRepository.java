package com.mcpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcpc.dto.StoreDTO;

public interface StoreRepository extends JpaRepository<StoreDTO, Long>{
	StoreDTO findBysNum(Long sNum);
	
	StoreDTO findBysId(String sId);
}
