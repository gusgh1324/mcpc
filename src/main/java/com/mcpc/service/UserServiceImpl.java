package com.mcpc.service;

import org.springframework.stereotype.Service;

import com.mcpc.dto.UserDTO;
import com.mcpc.mapper.UserServiceMapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserServiceMapper userServiceMapper;

	@Override
	public void join(UserDTO user) {
		userServiceMapper.join(user);
		
	}
	@Override
	public String idCheck(String uId) {
		return userServiceMapper.idCheck(uId);
	}
	@Override
	public UserDTO loginCheck(String uId) {
		return userServiceMapper.loginCheck(uId);
	}
}
