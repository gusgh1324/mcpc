package com.mcpc.service;

import java.util.List;

import com.mcpc.dto.WorldCupDTO;

public interface WorldCupService {
    List<WorldCupDTO> getMenu();
    List<WorldCupDTO> getRandomMenus();
}

