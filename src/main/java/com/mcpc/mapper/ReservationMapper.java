package com.mcpc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mcpc.model.MenuOrder;
import com.mcpc.model.Reservation;

@Mapper
public interface ReservationMapper {
    @Insert("INSERT INTO menu_order(id,menuname, menucount, reservationid) VALUES ( #{reservationId}, #{menuOrder.menuName}, #{menuOrder.menuCount}, #{reservationId})")
    public void menuOrderInsert(MenuOrder menuOrder, Long reservationId);

    @Select("SELECT LAST_INSERT_ID()")
    public Long getLastInsertId(); // 삽입한 마지막 행의 ID를 반환하는 쿼리
    
    @Insert("INSERT INTO reservation (person, hour, minute, etc, ordertime) VALUES (#{person}, #{hour}, #{minute}, #{etc}, now())")
    public void reservationInsert(Reservation reservation);
    
    @Select("SELECT * FROM reservation")
    public List<Reservation> list();
    
    @Select("SELECT * FROM menu_order")
    public List<MenuOrder> list2();
    
    @Select("SELECT MAX(id) FROM reservation")
    public int getMaxInsertId();
}
