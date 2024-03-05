package com.mcpc.dto;

// xptmxm

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StoreDTO {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storeId; // 가게 아이디, 자동으로 부여
	
	private String storeName; // 상호명
	private String storePassword; // 가게 비밀번호
	private String offDay; // 휴무일
}
