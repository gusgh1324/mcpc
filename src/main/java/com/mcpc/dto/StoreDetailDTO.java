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
@Table(name="storedetail")
public class StoreDetailDTO {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeid")
    private Long storeId; // 가게 아이디
    
    private String priminum; // 광고
    
    private String category; // 카테고리
    
    @Column(name = "offday")
    private String offDay; // 휴무일
    
    // 대표 메뉴
    @Column(name = "mainimage")
    private String mainImage; // 이미지
    @Column(name = "mainmenu")
    private String mainMenu; // 대표 메뉴
    @Column(name = "menuprice")
    private String menuPrice; // 대표 메뉴 가격
    
    // 일반 메뉴
    private String image; // 이미지
    private String menu; // 메뉴 이름
    private int price; // 가격

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storeid")
    private StoreDTO storeDTO; // StoreDTO와의 일대일 관계
    
}
