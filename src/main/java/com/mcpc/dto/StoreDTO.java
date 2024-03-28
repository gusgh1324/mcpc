package com.mcpc.dto;

import org.springframework.util.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="store")
public class StoreDTO {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "snum")
	private Long sNum; // 가게 아이디, 자동으로 부여
	
	@Column(name = "sid")
	private String sId; // 아이디
	
	@Column(name = "spw")
	private String sPw; // 가게 비밀번호
	
	@Column(name = "sname")
	private String sName; // 상호명
	
	@Column(name = "smobile")
	private int sMobile; // 전화번호
	
	@Column(name = "sbnum")
	private int sBNum; // 사업자 번호 Business Number

	
}
