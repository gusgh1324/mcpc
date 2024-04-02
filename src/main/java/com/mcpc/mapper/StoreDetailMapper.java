package com.mcpc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.mcpc.dto.StoreDetailDTO;

@Mapper
public interface StoreDetailMapper {
    
    @Insert("INSERT INTO store_detail (premium, category, offday, snum) " +
            "VALUES (#{premium}, #{category}, #{offDay}, #{sNum})")
    void saveStoreDetail(StoreDetailDTO storeDetailDTO);
}
