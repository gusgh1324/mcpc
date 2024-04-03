package com.mcpc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mcpc.dto.WorldCupDTO;

@Mapper
public interface WorldCupMapper {
    @Select("SELECT * FROM store_menu")
    List<WorldCupDTO> selectMenu();
}
