package com.mcpc.dto;

import com.mcpc.dto.StoreTest.Store;
import com.mcpc.dto.StoreTest.StoreDetail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "store_menu")
public class StoreMenuDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "snum")
	private Long sNum;
	
	@Column(name = "mnum")
	private Long mNum;
	
	@Column(name = "mname")
	private String mName; // 메뉴 이름
	
	@Column(name = "mprice")
	private String mPrice; // 가격
	
	@Column(name = "soldout")
	private String soldOut; // 품절

}
