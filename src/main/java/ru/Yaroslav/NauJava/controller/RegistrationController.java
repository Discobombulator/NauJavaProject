package ru.Yaroslav.NauJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.Yaroslav.NauJava.dateBase.entity.User;
import ru.Yaroslav.NauJava.controller.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Показывает страницу регистрации
     */
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    /**
     * Обрабатывает регистрацию нового пользователя
     */
    @PostMapping("/registration")
    public String addUser(User user, Model model) {

        try {
            userService.registerUser(user);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("message", "Пользователь уже существует");
            return "registration";
        }
    }
}