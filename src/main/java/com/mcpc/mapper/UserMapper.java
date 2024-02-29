package com.mcpc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mcpc.dto.UserDTO;


@Mapper
public interface UserMapper {
	//추가
	@Insert("insert into user values(#{userId}, #{userPassword},#{userEmail},#{userName}, #{userBirth}, #{userGender}, #{userPNumber} )")
	public void join(UserDTO user);
	//아이디 중복확인
	@Select("select count(*)  from user where id=#{userId}")
	public int idCheck(String userId);
	//로그인 체크
	@Select("select * from user where id=#{userId}")
	public UserDTO loginCheck(String userId);
}
