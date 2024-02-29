package com.mcpc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcpc.dto.WorldCupDTO;

@Service
public class WorldCupService {

    public void addSelectedImage(List<WorldCupDTO> selectedImages, String imagePath) {
        WorldCupDTO worldCupDTO = new WorldCupDTO();
        worldCupDTO.setImagePath(imagePath);
        selectedImages.add(worldCupDTO);
    }
}
