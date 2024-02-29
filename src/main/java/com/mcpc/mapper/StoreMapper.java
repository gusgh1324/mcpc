package com.mcpc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.mcpc.dto.StoreDTO;


@Mapper
public interface StoreMapper {
	//추가
	@Insert("INSERT INTO store (storePassword ,category, image, storeName, mainMenu, menuPrice, priminum, offDay) " +
            "VALUES (#{storePassword},#{category}, #{image}, #{storeName}, #{mainMenu}, #{menuPrice}, #{priminum}, #{offDay})")
    void storeJoin(StoreDTO storeDTO);
}
