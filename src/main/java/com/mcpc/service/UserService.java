package com.mcpc.service;

import org.springframework.stereotype.Service;

import com.mcpc.dto.UserDTO;
import com.mcpc.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private  final UserMapper userMapper;
	
	// 회원가입 처리
    public void join(UserDTO user) {
        userMapper.join(user);
    }
    public UserDTO login(String userId, String userPassword) {
        // 실제 로그인 처리를 수행하는 코드를 작성합니다.
        // 예시로 UserMapper를 사용하여 사용자의 아이디와 비밀번호가 일치하는지 확인하는 코드를 작성합니다.
        return userMapper.login(userId, userPassword);
    }
	
}
