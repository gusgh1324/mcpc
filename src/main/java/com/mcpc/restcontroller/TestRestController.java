package com.mcpc.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcpc.dto.ReMenuOrderDTO;
import com.mcpc.dto.ReservationDTO;
import com.mcpc.dto.StoreDTO;
import com.mcpc.dto.StoreDetailDTO;
import com.mcpc.dto.StoreMenuDTO;
import com.mcpc.dto.UserDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestRestController {
	private final TestRestService testRestService;
	
	@GetMapping("/users")
	public List<UserDTO> viewUser(){
    	return testRestService.viewUser();
    }
	
	@GetMapping("/stores")
	public List<StoreDTO> viewStore(){
		return testRestService.viewStore();
	}
	
	@GetMapping("/details")
	public List<StoreDetailDTO> viewDetail(){
		return testRestService.viewDetail();
	}
	
	@GetMapping("/menus")
	public List<StoreMenuDTO> viewMenu(){
		return testRestService.viewMenu();
	}
	@GetMapping("/reservations")
	public List<ReservationDTO> viewReservation(){
		return testRestService.viewReservation();
	}
	@GetMapping("/menuOrders")
	public List<ReMenuOrderDTO> viewReMenuOrder(){
		return testRestService.viewReMenuOrder();
	}
	
	
	@GetMapping("/all")
    public TestDataDTO getAllData() {
        TestDataDTO testData = new TestDataDTO();
        testData.setUsers(testRestService.viewUser());
        testData.setStores(testRestService.viewStore());
        testData.setDetails(testRestService.viewDetail());
        testData.setMenus(testRestService.viewMenu());
        testData.setReservations(testRestService.viewReservation());
        testData.setMenuOrders(testRestService.viewReMenuOrder());
        return testData;
    }

}
