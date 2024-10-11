package com.hyuk.hyukweb.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping(value = "hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "study/hello";
    }

    @GetMapping(value = "hello-mvc")
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "study/hello-template";
    }

    @GetMapping("hello-String")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping(value = "hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value = "name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public Hello setName(String name) {
            this.name = name;
            return this;
        }
    }
}
