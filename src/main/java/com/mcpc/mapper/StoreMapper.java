package com.mcpc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.StoreDetailDTO;


@Mapper
public interface StoreMapper {
	// 회원가입
	@Insert("INSERT INTO store (storeName, storePassword) " +
            "VALUES (#{storeName},#{storePassword} )")
    void storeJoin(StoreDTO storeDTO);

	// 모든 가게 정보 가져오기
	@Select("SELECT * FROM store")
	List<StoreDTO> getAllStores();

	// 메뉴 추가
    @Insert("INSERT INTO storedetail (priminum, category, offDay, mainImage, mainMenu, menuPrice, image, menu, price) " +
            "VALUES (#{priminum}, #{category}, #{offDay}, #{mainImage}, #{mainMenu}, #{menuPrice}, #{image}, #{menu}, #{price} )")
    void storeDetail(@Param("storeId") Long storeId, StoreDetailDTO storeDetailDTO);
}
