package com.mcpc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mcpc.dto.UserDTO;


@Mapper
public interface UserMapper {
	// 회원가입
    @Insert("INSERT INTO user (uid, upw, uemail, uname, ubirth, ugender, umobile) " +
            "VALUES (#{uId}, #{uPw}, #{uEmail}, #{uName}, #{uBirth}, #{uGender}, #{uMobile})")
    void join(UserDTO user);
    
    // 로그인 : 아이디와 비밀번호로 사용자 조회
    @Select("SELECT * FROM user WHERE uid = #{uId} AND upw = #{uPw}")
    UserDTO login(String uId, String uPw);
}