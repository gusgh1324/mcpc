package com.mcpc.dto1;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="store")
public class StoreDTO {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "snum")
	private Long sNum; // num
	
	@Column(name = "sid")
	private String sId; // id
	
	@Column(name = "spw")
	private String sPw; // 가게 비밀번호
	
	@Column(name = "sname")
	private String sName; // 상호명
	
	@Column(name = "smobile")
	private String sMobile; // 전화번호
	
	@Column(name = "businessnumr")
	private String businessNum; // 사업자번호
	
	@OneToMany(mappedBy = "storeDTO", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StoreDetailDTO> storeDetailDTO;
	
	@OneToMany(mappedBy = "storeDTO", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StoreMenuDTO> storeMenuDTO;
	
	@OneToMany(mappedBy = "storeDTO", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReservationDTO> reservationDTO;
	
	@OneToMany(mappedBy = "storeDTO", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewDTO> reviewDTO;
}
