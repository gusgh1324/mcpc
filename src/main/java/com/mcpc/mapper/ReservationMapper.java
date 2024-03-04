package com.mcpc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mcpc.model.MenuOrder;
import com.mcpc.model.Reservation;

@Mapper
public interface ReservationMapper {
    @Insert("INSERT INTO reservation (person, hour, minute, etc, order_time) VALUES (#{person}, #{hour}, #{minute}, #{etc}, now())")
    void reservationInsert(Reservation reservation);
    
    @Insert({
        "<script>",
        "INSERT INTO menu_order(menu_name, menu_count) VALUES ",
        "<foreach item='menuOrder' collection='menuOrders' separator=','>",
            "(#{menuOrder.menuName}, #{menuOrder.menuCount})",
        "</foreach>",
        "</script>"
    })
    void menuOrderInsert(MenuOrder[] menuOrders);
    

}
