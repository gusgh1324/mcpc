package com.mcpc.service;

import org.springframework.stereotype.Service;

import com.mcpc.dto.UserDTO;
import com.mcpc.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private  final UserMapper userMapper;
	
	//추가
	public void join(UserDTO user) {
		userMapper.join(user);
	}
	//아이디 체크
	public int idCheck(String userId) {
		return userMapper.idCheck(userId);
	}
	//로그인체크
	public UserDTO loginCheck(String userId) {
		return userMapper.loginCheck(userId);
	}
	
}
