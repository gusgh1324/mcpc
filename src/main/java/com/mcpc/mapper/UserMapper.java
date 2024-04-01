package com.mcpc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mcpc.dto.UserDTO;

@Mapper
public interface UserMapper {
	@Insert("insert into user values(#{uNum},#{uBirth}, #{uEmail}, #{uGender}, #{uId}, "
			+ "#{uMobile}, #{uName}, #{uPw})")
	public void join(UserDTO user);

	@Select("select count(*) from user where uId=#{uId}")
	public String idCheck(String uId);

	@Select("select * from user where uId=#{uId}")
	public UserDTO loginCheck(String uId);

}
