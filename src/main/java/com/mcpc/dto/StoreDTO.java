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
	@Column(name = "storeid")
	private Long storeId; // 가게 아이디, 자동으로 부여
	
	@Column(name = "storename")
	private String storeName; // 상호명
	
	@Column(name = "storepassword")
	private String storePassword; // 가게 비밀번호
	
	
	
    public boolean isValid() {
        return !StringUtils.isEmpty(storeName) && !StringUtils.isEmpty(storePassword);
    }
}
