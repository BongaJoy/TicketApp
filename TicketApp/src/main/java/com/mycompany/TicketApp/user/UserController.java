package com.mycompany.TicketApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired private  UserService service;

    @GetMapping("/login")
    public  String showLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public  String showRegisterPage(Model model) {
        List<User> userLists = service.listAll();
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/save")
    public String saveUser(User user, RedirectAttributes ra) {
        service.save(user);
        return "redirect:/login";
    }

    @GetMapping("/password")
    public  String showPasswordPage(Model model) {
        return "password";
    }

    @GetMapping("/ticket")
    public  String showTicketPage(Model model) {
        return "ticket";
    }


}
