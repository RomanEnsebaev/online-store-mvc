package edu.epam.fop.controller;

import edu.epam.fop.entity.User;
import edu.epam.fop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user) {
        userService.register(user);
        return "redirect:/login?registered";
    }
}