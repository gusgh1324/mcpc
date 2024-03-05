package com.mcpc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MenuOrder {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
	
    private int id;

    @ManyToOne
    @JoinColumn(name = "reservationid")
    private Reservation reservation;

    @Column(name = "menuname")
    private String menuName;

    @Column(name = "menucount")
    private int menuCount; // 메뉴의 갯수를 세줌

}
