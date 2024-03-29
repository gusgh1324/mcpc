package com.mcpc.dto;

import java.util.Date;
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
@Table(name="Reservation")
public class ReservationDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rnum")
    private Long rNum;

    private int person;
    private int hour;
    private int minute;
    private String etc;
    
    @Column(name = "ordertime")
    private Date orderTime;
    
    @ManyToOne
    @JoinColumn(name = "snum")
    private StoreDTO storeDTO;
    
    @ManyToOne
    @JoinColumn(name = "unum")
    private UserDTO userDTO;
    
    public Long getSnum() {
        if (this.storeDTO != null) {
            return this.storeDTO.getSNum();
        }
        return null;
    }

    public Long getUnum() {
        if (this.userDTO != null) {
            return this.userDTO.getUNum();
        }
        return null;
    }
    

    @OneToMany(mappedBy = "reservationDTO", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReMenuOrderDTO> reMenuOrderDTO;
}
