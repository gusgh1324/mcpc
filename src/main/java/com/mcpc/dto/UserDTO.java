package com.mcpc.dto;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user")
public class UserDTO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unum")
    private Long uNum; // 아이디를 숫자로 변경
    
    @Column(name = "uid")
    private String uId; // 아이디를 숫자로 변경

    @Column(name = "upw")
    private String uPw; // 비밀번호

    @Column(name = "uemail")
    private String uEmail; // 이메일

    @Column(name = "uname")
    private String uName; // 이름

    @Column(name = "ubirth")
    private Date uBirth; // 생년월일

    @Column(name = "ugender")
    private String uGender; // 성별

    @Column(name = "umobile")
    private String uMobile; // 전화번호
    
    @OneToMany(mappedBy = "userDTO", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservationDTO> reservation;
    @OneToMany(mappedBy = "userDTO", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewDTO> review;
}