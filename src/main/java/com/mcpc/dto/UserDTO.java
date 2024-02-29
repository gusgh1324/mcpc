package com.mcpc.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="users") // "user" 대신 "users"로 변경
public class UserDTO {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; // 아이디를 숫자로 변경

    private String userPassword; // 비밀번호
    private String userEmail; // 이메일
    private String userName; // 이름
    private String userBirth; // 생년월일
    private String userGender; // 성별
    private String userPNumber; // 전화번호
}
