package com.example.tobi.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SelectController {

    @GetMapping("/main")
    public String main(
            @RequestParam(name="sectionId",defaultValue = "") String sectionId,
            Model model
    ) {
        model.addAttribute("sectionId", sectionId);
        return "main";
    }

    @GetMapping("/select")
    public String select() {
        return "select";
    }

}
