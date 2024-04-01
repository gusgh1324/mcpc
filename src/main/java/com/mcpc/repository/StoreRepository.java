package com.mcpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.UserDTO;

public interface StoreRepository extends JpaRepository<StoreDTO, Long>{
	StoreDTO findBysNum(Long sNum);
	
	StoreDTO findBysId(String sId);
	
}
