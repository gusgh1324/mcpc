package com.mcpc.dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="review")
public class ReviewDTO {
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rnum")
	private int rNum;
	
	private String title;
	private String content;
	private Date regdate;
	private int hitcount;
	
	@ManyToOne
	@JoinColumn(name = "snum")
    private StoreDTO storeDTO;
    
    @ManyToOne
    @JoinColumn(name = "unum")
    private UserDTO userDTO;
	
}

