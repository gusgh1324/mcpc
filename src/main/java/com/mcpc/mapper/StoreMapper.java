package com.mcpc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import com.mcpc.dto.StoreDTO;
import java.util.List;


@Mapper
public interface StoreMapper {
	// 회원가입
	@Insert("INSERT INTO store (sid, spw, sname, smobile, businessnum) " +
	        "VALUES (#{sId}, #{sPw}, #{sName}, #{sMobile}, #{businessNum})")
	void storeJoin(StoreDTO storeDTO);
	
	 @Select("SELECT * FROM store WHERE sId = #{sid}")
	 List<StoreDTO> findStoreById(@Param("sid") String sId);
}
 