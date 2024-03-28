package com.mcpc.service;

import com.mcpc.dto.UserDTO;

public interface UserService {
	//회원가입
	public void join(UserDTO user);
	//로그인
	public String idCheck(String uId);
	//로그인체크
	public UserDTO loginCheck(String uId);
}
