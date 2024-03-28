package com.mcpc.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="store_detail")
public class StoreDetailDTO {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "snum")
	private Long sNum; // 가게 아이디, 자동으로 부여
	
	@Column(name = "mnum")
	private Long mNum;
    
    private String priminum; // 광고
    
    private String category; // 카테고리
    
    @Column(name = "offday")
    private String offDay; // 휴무일
    
}
