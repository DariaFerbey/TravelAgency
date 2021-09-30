package com.softserve.controller;

import com.softserve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @GetMapping({"/login", "/"})
    public String loginForm(Model model, @RequestParam(value = "error", required = false) String error) {
        boolean errorMessage = false;
        if (error != null) {
            errorMessage = true;
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    @PreAuthorize("hasAuthority('all_permissions')")
    @GetMapping("/management")
    public String managementAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "management";
    }
}
