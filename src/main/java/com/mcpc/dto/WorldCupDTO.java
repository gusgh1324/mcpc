package com.mcpc.dto;

public class WorldCupDTO {
    private String imagePath;

    public WorldCupDTO() {
    }

    public WorldCupDTO(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
