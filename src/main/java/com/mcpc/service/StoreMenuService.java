package com.mcpc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mcpc.dto.StoreMenuDTO;
import com.mcpc.mapper.StoreMapper;
import com.mcpc.mapper.StoreMenuMapper;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class StoreMenuService {
    private final StoreMenuMapper storeMenuMapper;

    // 메뉴 추가
    public void menuInsert(StoreMenuDTO storeMenuDTO) {
        storeMenuMapper.menuInsert(storeMenuDTO);
    }

    // 메뉴 목록 조회
    public List<StoreMenuDTO> menuList() {
        return storeMenuMapper.menuList();
    }
}
