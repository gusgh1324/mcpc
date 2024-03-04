package com.mcpc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcpc.dto.WorldCupDTO;
import com.mcpc.service.WorldCupService;

@Controller
public class WorldCupController {

    private final List<String> images = new ArrayList<>(List.of(
            "/images/image1.jpg",
            "/images/image2.jpg",
            "/images/image3.jpg",
            "/images/image4.jpg",
            "/images/image5.jpg",
            "/images/image6.jpg",
            "/images/image7.jpg",
            "/images/image8.jpg"
    ));

    private final List<WorldCupDTO> selectedImages = new ArrayList<>();

    @Autowired
    private WorldCupService worldCupService;

    @GetMapping("/menuWorldCup/worldCup")
    public String showWorldCupMenuPage() {
        return "/menuWorldCup/worldCup";
    }

    @GetMapping("/menuWorldCup/start")
    public String redirectToStartPage() {
        return "redirect:/menuWorldCup/round8_1";
    }

    @GetMapping("/round8_1")
    public String showRound8_1Page(Model model) {
        String image1 = getRandomImagePath();
        String image2 = getRandomImagePath();
        selectedImages.clear(); // Clear the selected images from previous rounds
        selectedImages.add(new WorldCupDTO(image1));
        selectedImages.add(new WorldCupDTO(image2));
        model.addAttribute("image1", image1);
        return "/menuWorldCup/round8_1";
    }

    @GetMapping("/menuWorldCup/round8_1")
    public String proceedToNextRound1(Model model) {
        return "/menuWorldCup/round8_1";
    }

    @GetMapping("/menuWorldCup/round8_2")
    public String proceedToNextRound2(Model model) {
        return "/menuWorldCup/round8_2";
    }

    @GetMapping("/menuWorldCup/round8_3")
    public String proceedToNextRound3(Model model) {
        return "/menuWorldCup/round8_3";
    }

    @GetMapping("/menuWorldCup/round8_4")
    public String proceedToNextRound4(Model model) {
        return "/menuWorldCup/round8_4";
    }

    @PostMapping("/menuWorldCup/round8_1")
    public String handleImageClick(@RequestParam("selectedImage") String selectedImage) {
        selectedImages.clear(); // Clear previous selections
        selectedImages.add(new WorldCupDTO(selectedImage)); // Add selected image to the list
        return "redirect:/menuWorldCup/round8_2";
    }

    @PostMapping("/menuWorldCup/round8_2")
    public String handleRound8_2FormSubmission(@RequestParam("selectedImage1") String selectedImage1,
                                                @RequestParam("selectedImage2") String selectedImage2) {
        selectedImages.clear(); // Clear previous selections
        selectedImages.add(new WorldCupDTO(selectedImage1)); // Add selected images to the list
        selectedImages.add(new WorldCupDTO(selectedImage2));
        return "redirect:/menuWorldCup/round8_3";
    }

    @PostMapping("/menuWorldCup/round8_3")
    public String handleRound8_3FormSubmission(@RequestParam("selectedImage3") String selectedImage3,
                                                @RequestParam("selectedImage4") String selectedImage4) {
        selectedImages.add(new WorldCupDTO(selectedImage3));
        selectedImages.add(new WorldCupDTO(selectedImage4));
        return "redirect:/menuWorldCup/round8_4";
    }

    @PostMapping("/menuWorldCup/round8_4")
    public String handleRound8_4FormSubmission(@RequestParam("selectedImage5") String selectedImage5,
                                                @RequestParam("selectedImage6") String selectedImage6) {
        selectedImages.add(new WorldCupDTO(selectedImage5));
        selectedImages.add(new WorldCupDTO(selectedImage6));
        return "redirect:/menuWorldCup/round4_1";
    }
    @GetMapping("/menuWorldCup/round4")
    public String showRound4_1Page(Model model) {
        // Add necessary logic to populate the model
        return "/menuWorldCup/round4"; // Assuming there is a corresponding HTML template
    }


    private String getRandomImagePath() {
        if (images.isEmpty()) return null;
        Random random = new Random();
        int index = random.nextInt(images.size());
        return images.remove(index);
    }
}