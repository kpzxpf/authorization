package com.example.authorization.controllers;

import com.example.authorization.models.Role;
import com.example.authorization.models.User;
import com.example.authorization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String authorization(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", true);
        } else {
            model.addAttribute("error", false);
        }
        return "authorization";
    }

    @PostMapping("/login")
    public String login(@RequestParam String login, @RequestParam String password) {
        User user = userService.findByLoginAndPassword(login, password);

        if (user != null) {
            return "redirect:/account/" + user.getId();
        } else {
            return "redirect:/?error=true";
        }
    }
    @GetMapping("/account/{id}")
    public String account(@PathVariable long id, Model model){
        User user = userService.findById(id);

        if (user != null) {
            String role = user.getRole().getRole();
            model.addAttribute("role", role);
            return "account";
        } else {

            return "error";
        }
    }
    @GetMapping("/signup")
    public String signup() {
        return "registration";
    }
    @PostMapping("/signup.account")
    public String signupAccount(@RequestParam String login, @RequestParam String password){
        Role role = new Role();
        role.setId(2);
        userService.save(new User(login, password,role));
        return "redirect:/";
    }
}

