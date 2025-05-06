package edu.epam.fop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestController {
    @GetMapping("/test")
    @ResponseBody
    public String hello() {
        return "layout";
    }
}
