package com.mcpc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.StoreDetailDTO;
import com.mcpc.dto.StoreMenuDTO;

@Mapper
public interface StoreListMapper {
	
	@Select("select * from store_detail")
    public List<StoreDetailDTO> list();
	
	@Select("select * from store_menu")
	public List<StoreMenuDTO> list2();
	
	@Select("select * from store")
	public List<StoreDTO> list3();
	
	@Select("SELECT mname FROM store_menu WHERE snum = #{sId}")
	public List<StoreMenuDTO> listDetail(Long sId);
}
