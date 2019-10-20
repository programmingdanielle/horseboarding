package com.horseboarding.horseboarding.controllers;

import com.horseboarding.horseboarding.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model) {
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute User user, String verify) {

        if (user.getPassword() != null && user.getPassword().equals(verify)) {
            model.addAttribute("name", user.getUsername());
            return "welcome";
        }

        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("error", "Passwords do not match");
        return "welcome";
    }
}
