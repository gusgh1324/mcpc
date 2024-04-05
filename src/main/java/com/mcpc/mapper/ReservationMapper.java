package com.mcpc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import com.mcpc.dto.ReMenuOrderDTO;
import com.mcpc.dto.ReservationDTO;

@Mapper
public interface ReservationMapper {
    @Insert("insert into reservation (rNum, etc, hour, minute, orderTime, person, snum, unum) values(#{rNum}, #{etc}, #{hour}, #{minute}, now(), #{person}, #{sNum}, #{uNum})")
    public void insert(ReservationDTO reservation);

    @Insert("INSERT INTO remenuorder ( menuCount, orderMenu, priceMenu, rnum, uNum) " +
            "VALUES ( #{menuCount}, #{orderMenu},#{priceMenu}, (SELECT rnum FROM Reservation ORDER BY rnum DESC LIMIT 1), #{uNum})")
    public void insertmenu(ReMenuOrderDTO reMenuOrder);


    
    @Select("select * from reservation")
    public List<ReservationDTO> list();
    
    @Select("select * from remenuorder")
    public List<ReMenuOrderDTO> listmenu();
    
    
    
    @Select("SELECT MAX(rnum) FROM remenuorder WHERE uNum = #{uNum};")
    public Long max(Long uNum);

    @Select("SELECT * FROM reservation WHERE unum = #{uNum}")
    List<ReservationDTO> getReservationsByUNum(@Param("uNum") Long uNum);
}
