package com.mcpc.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcpc.dto.WorldCupDTO;
import com.mcpc.mapper.WorldCupMapper;

@Service
public class WorldCupServiceImpl implements WorldCupService {

    private final WorldCupMapper worldCupMapper;

    @Autowired
    public WorldCupServiceImpl(WorldCupMapper worldCupMapper) {
        this.worldCupMapper = worldCupMapper;
    }

    @Override
    public List<WorldCupDTO> getMenu() {
        return worldCupMapper.selectMenu();
    }
    

    @Override
    public List<WorldCupDTO> getRandomMenus() {
        List<WorldCupDTO> menuList = worldCupMapper.selectMenu();
        Collections.shuffle(menuList);
        return menuList.subList(0, 8); // 8개의 랜덤한 메뉴 선택
    }

}
