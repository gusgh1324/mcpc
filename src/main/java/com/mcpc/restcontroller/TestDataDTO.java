package com.mcpc.restcontroller;

import java.util.List;

import com.mcpc.dto.ReMenuOrderDTO;
import com.mcpc.dto.ReservationDTO;
import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.StoreDetailDTO;
import com.mcpc.dto.StoreMenuDTO;
import com.mcpc.dto.UserDTO;

import lombok.Data;

@Data
public class TestDataDTO {
    private List<UserDTO> users;
    private List<StoreDTO> stores;
    private List<StoreDetailDTO> details;
    private List<StoreMenuDTO> menus;
    private List<ReservationDTO> reservations;
    private List<ReMenuOrderDTO> menuOrders;
}
