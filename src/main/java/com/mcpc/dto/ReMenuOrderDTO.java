package com.mcpc.dto;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="remenuorder")
public class ReMenuOrderDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "onum")
    private Long oNum;
	@Column(name = "ordermenu")
	private String orderMenu;
	@Column(name = "menucount")
	private int menuCount;
	
	
	
	 @ManyToOne
	 @JoinColumn(name = "rnum")
	 private ReservationDTO reservationDTO;
	 @Transient
	 private Long rNum;
	 
	 @ManyToOne
	 @JoinColumn(name = "unum")
	 private UserDTO userDTO;
	 @Transient
	 private Long uNum;
	 
	 

}
