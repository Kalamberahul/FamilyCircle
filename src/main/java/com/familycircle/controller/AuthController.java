package com.familycircle.controller;

import com.familycircle.model.User;
import com.familycircle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") User user) {
        userService.registerUser(user);  // Encodes password and saves user
        return "redirect:/login?registerSuccess";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html
    }

    // ⛔️ Removed this to avoid duplicate mapping
    // @GetMapping("/home")
    // public String showHomePage() {
    //     return "home"; 
    // }
}
