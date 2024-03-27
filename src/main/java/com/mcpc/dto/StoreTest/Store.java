package com.mcpc.dto.StoreTest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "store1")
public class Store {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long snum;
	@Column(nullable = false)
	private String sname;
	private String spw;
	private String smobile;
}