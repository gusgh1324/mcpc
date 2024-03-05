package com.mcpc.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreDetailDTO {
	private Long storeId; // 가게 아이디
	
	private String priminum; // 광고
	private String category; // 카테고리
	
	// 대표 메뉴
	private String mainImage; // 이미지
	private String mainMenu; // 대표 메뉴
	private String menuPrice; // 대표 메뉴 가격
	
	// 일반 메뉴
	private String image; // 이미지
	private String menu; // 메뉴 이름
	private int price; // 가격

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeId")
	private StoreDTO storeDTO; // StoreDTO와의 일대일 관계
	
}
