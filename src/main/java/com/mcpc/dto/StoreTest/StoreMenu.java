package com.mcpc.dto.StoreTest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "store_menu")
public class StoreMenu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mnum;
    
    @Column(name = "menuimage")
    private String storeMenuImage;
    @Column(name = "menuname")
    private String storeMenuName;
    @Column(name = "menuprice")
    private String storeMenuPrice;
    
    @ManyToOne
    @JoinColumn(name = "dnum")
    private StoreDetail storeDetail; 
    

  	@ManyToOne
  	@JoinColumn(name = "snum")
  	private Store store;
  }
