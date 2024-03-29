package com.mcpc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.mcpc.dto.ReMenuOrderDTO;
import com.mcpc.dto.ReservationDTO;

@Mapper
public interface ReservationMapper {
    @Insert("insert into reservation (rNum, etc, hour, minute, orderTime, person, snum, unum) values(#{rNum}, #{etc}, #{hour}, #{minute}, now(), #{person}, #{storeDTO.sNum}, #{userDTO.uNum})")
    public void insert(ReservationDTO reservation);

    @Insert("INSERT INTO remenuorder (oNum, menuCount, orderMenu, rnum) " +
            "VALUES (#{oNum}, #{menuCount}, #{orderMenu}, " +
            "(SELECT rnum FROM Reservation ORDER BY rnum DESC LIMIT 1))")
    public void insertmenu(ReMenuOrderDTO reMenuOrder);
}
