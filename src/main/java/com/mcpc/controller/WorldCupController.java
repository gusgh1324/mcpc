package com.mcpc.controller;

import com.mcpc.dto.WorldCupDTO;
import com.mcpc.service.WorldCupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/worldCup")
public class WorldCupController {

    private final WorldCupService worldCupService;

    @GetMapping
    public String worldCup(Model model) {
        List<WorldCupDTO> menuList = worldCupService.getRandomMenus(); // getRandomMenus 메서드 호출
        model.addAttribute("menuList", menuList);
        return "worldCup";
    }

}
