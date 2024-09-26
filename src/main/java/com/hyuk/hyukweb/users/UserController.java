package com.hyuk.hyukweb.users;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import static javax.swing.UIManager.put;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("register/login");
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("register/register");
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public String postRegister(UserEntity user) {
        RegisterResult result = this.userService.register(user);
        JSONObject json = new JSONObject(){{
            put("result", result.name().toLowerCase());
        }};
        return json.toString();
    }
}
