package com.mcpc.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
    private String mPrice; 
    
    private String description; 
    
    private boolean inventory; // 재고
    
    
    @Column(name = "filename")
    private String fileName; 
    @Column(name = "fileurl")
    private String fileUrl; 
    @Column(name = "uuid")
    private String UUID;
   
   
    @ManyToOne
    @JoinColumn(name = "snum")
    private StoreDTO storeDTO;
    
    @ManyToOne
    @JoinColumn(name = "dnum")
    private StoreDetailDTO storeDetailDTO; 
    
}
