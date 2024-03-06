package com.mcpc.dto;

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
@Table(name="user")
public class UserDTO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId; // 아이디를 숫자로 변경

    @Column(name = "userpassword")
    private String userPassword; // 비밀번호

    @Column(name = "useremail")
    private String userEmail; // 이메일

    @Column(name = "username")
    private String userName; // 이름

    @Column(name = "userbirth")
    private String userBirth; // 생년월일

    @Column(name = "usergender")
    private String userGender; // 성별

    @Column(name = "userpnumber")
    private String userPNumber; // 전화번호
}