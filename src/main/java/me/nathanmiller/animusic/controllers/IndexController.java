package me.nathanmiller.animusic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//MVC
@Controller
public class IndexController {

    @GetMapping

    public String getHomePage(Model model) {
        return "index";
    }

}
