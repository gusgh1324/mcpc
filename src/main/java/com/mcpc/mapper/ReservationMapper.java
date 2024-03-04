package com.mcpc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mcpc.model.MenuOrder;
import com.mcpc.model.Reservation;

@Mapper
public interface ReservationMapper {
	////
    @Insert("INSERT INTO menu_order(menu_name, menu_count, reservation_id) VALUES (#{menuOrder.menuName}, #{menuOrder.menuCount}, #{reservationId})")
    void menuOrderInsert(MenuOrder menuOrder, Long reservationId);

    @Insert("INSERT INTO reservation (person, hour, minute, etc, order_time) VALUES (#{person}, #{hour}, #{minute}, #{etc}, now())")
    void reservationInsert(Reservation reservation);

    @Select("SELECT LAST_INSERT_ID()")
    Long getLastInsertId(); // 삽입한 마지막 행의 ID를 반환하는 쿼리
    ////
       
    
    @Select("SELECT * FROM reservation")
    List<Reservation> list();
}