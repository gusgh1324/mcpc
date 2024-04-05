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
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="store_menu")
public class StoreMenuDTO {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mnum")
    private Long mNum; 
    
    @Column(name = "mname")
    private String mName; 
    
    @Column(name = "mprice")
    private int mPrice; 
    
    private String description; 
    
    
    //@Column(name = "imagefile")
    //private String imageFile; 

    // 이미지 파일의 경로를 저장
    //@Column(name = "fileurl")
    //private String fileUrl; 
    
    //@Column(name = "uuid")
    //private String UUID;
   
    @ManyToOne
    @JoinColumn(name = "snum")
    private StoreDTO storeDTO;
    @Transient
    private Long sNum;
    
 
    
}
