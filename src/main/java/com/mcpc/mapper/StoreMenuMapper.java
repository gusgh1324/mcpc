package com.mcpc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mcpc.dto.StoreMenuDTO;

@Mapper
public interface StoreMenuMapper {
	@Insert("insert into store_menu(mname, mprice, description, inventory, fileurl, uuid, snum, dnum) \r\n"
			+ "values (#{mName}, #{mPrice}, #{description}, #{inventory}, #{fileUrl}, #{UUID}, #{storeDTO.sNum}, #{storeDetailDTO.dNum})")
	public void menuInsert(StoreMenuDTO storeMenuDTO);
	
	@Select("select*from store_menu")
	public List<StoreMenuDTO> menuList();
}
