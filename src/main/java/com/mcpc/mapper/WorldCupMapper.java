package com.mcpc.mapper;

import org.springframework.stereotype.Component;

import com.mcpc.dto.WorldCupDTO;

@Component
public class WorldCupMapper {

    public String mapToImagePath(WorldCupDTO worldCupDTO) {
        return worldCupDTO.getImagePath();
    }
}