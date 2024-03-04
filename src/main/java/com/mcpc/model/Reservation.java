package com.mcpc.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int person;
    private int hour;
    private int minute;
    private String etc;
    private Date orderTime;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<MenuOrder> menuOrders;

}

