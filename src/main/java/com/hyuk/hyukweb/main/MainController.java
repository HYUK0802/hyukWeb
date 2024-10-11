package com.hyuk.hyukweb.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public ModelAndView getMain() {
        ModelAndView modelAndView = new ModelAndView("main");
        return modelAndView;
    }



}
