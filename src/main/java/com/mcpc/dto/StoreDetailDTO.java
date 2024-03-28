package com.mcpc.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="store_detail")
public class StoreDetailDTO {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dnum")
    private Long dNum; 
    
    
    private String premium; // 광고
    
    private String category; // 카테고리
    
    @Column(name = "offday")
    private String offDay; // 휴무일
    
    @ManyToOne
    @JoinColumn(name = "snum")
    private StoreDTO storeDTO; 
   
    
}
