package com.hyuk.hyukweb.users;

import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static javax.swing.UIManager.put;

@Controller
@RequestMapping("/")
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

    @PostMapping(value = "/login")
    @ResponseBody
    public String postLogin(HttpSession session, UserEntity user) {
        // 로그인 시 입력된 UserEntity 값 출력 (디버깅용)
        System.out.println("User ID: " + user.getUserid());
        System.out.println("User Password: " + user.getPassword());

        // 로그인 결과 확인
        LoginResult result = this.userService.login(user);

        if(result == LoginResult.SUCCESS) {
            // 세션에 로그인 정보 저장
            session.setAttribute("user", user);

            // 로그인 성공 후 유저 정보 확인 (디버깅용)
            System.out.println("Login Successful. User saved in session.");
        } else {
            System.out.println("Login failed. Result: " + result);
        }

        // JSON 응답 객체 생성 및 결과 반환
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result.name().toLowerCase());

        return jsonObject.toString();
    }


    @GetMapping(value = "/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("register/register");
        return modelAndView;
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public String postRegister(UserEntity user) {
        RegisterResult result = this.userService.register(user);
        JSONObject json = new JSONObject(){{
            put("result", result.name().toLowerCase());
        }};
        return json.toString();
    }
}
