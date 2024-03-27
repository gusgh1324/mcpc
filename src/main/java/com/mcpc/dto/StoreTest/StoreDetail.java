package com.mcpc.dto.StoreTest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "store_detail")
public class StoreDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dnum;
    @Column(name = "offday")
    private String offDay;
    private String category;
    
    @OneToMany(mappedBy = "storeDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("storeDetail")
    private List<StoreMenu> storeMenu;
    
    @ManyToOne
    @JoinColumn(name = "snum")
    private Store store;
}