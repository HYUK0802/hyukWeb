package com.hyuk.hyukweb.boards;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    @GetMapping(value = "/board")
    public ModelAndView getBoard() {
        ModelAndView modelAndView = new ModelAndView("board/board");
        return modelAndView;
    }
    @GetMapping(value = "/write")
    public ModelAndView getWrite() {
        ModelAndView modelAndView = new ModelAndView("board/write");
        return modelAndView;
    }
}
