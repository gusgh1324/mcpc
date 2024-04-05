package com.mcpc.controller;

import com.mcpc.dto.WorldCupDTO;
import com.mcpc.service.StoreListService;
import com.mcpc.service.StoreService;
import com.mcpc.service.WorldCupService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class WorldCupController {

    private final WorldCupService worldCupService;
    private final StoreListService storeListService;

    @GetMapping("/worldCup")
    public String worldCup(Model model, HttpSession session) {
        List<WorldCupDTO> menuList = worldCupService.getRandomMenus(); // getRandomMenus 메서드 호출
        model.addAttribute("menuList", menuList);
        List<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);

        model.addAttribute("test",test);
        session.setAttribute("selectedMnums", new ArrayList<String>()); // 세션에 선택된 메뉴 번호를 저장할 배열 초기화
        return "worldCup";
    }

    // 선택된 메뉴 번호를 세션에 저장하는 메서드
    @GetMapping("/saveMnum")
    public String saveMnum(String mnum, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> selectedMnums = (List<String>) session.getAttribute("selectedMnums");
        selectedMnums.add(mnum);
        session.setAttribute("selectedMnums", selectedMnums);

        // 만약 선택된 메뉴 번호가 4개라면 SecondMatch 페이지로 이동
        if (selectedMnums.size() == 4) {
            return "redirect:/secondMatch";
        }

        // 아직 4개가 아니면 현재 페이지 유지
        return "redirect:/worldCup";
    }

    // SecondMatch 페이지로 이동하는 메서드
    @GetMapping("/secondMatch")
    public String secondMatch() {
        return "secondMatch";
    }
    // finalMatch 페이지로 이동하는 메서드
    @GetMapping("/finalMatch")
    public String finalMatch() {
    	return "finalMatch";
    }
    // endGame 페이지로 이동하는 메서드
    @GetMapping("/endGame")
    public String endGame(Model model) {
    	model.addAttribute("store", storeListService.list3());
    	model.addAttribute("storeM", storeListService.list2());
    	return "endGame";
    }
}
