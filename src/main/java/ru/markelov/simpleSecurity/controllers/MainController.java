package ru.markelov.simpleSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String homePage() {
        return "Главная страница";
    }

    @GetMapping("/unsecured")
    public String usecuredPage() {
        return "unsecured";
    }

    @GetMapping("/auth_page")
    public String authenticatedPage() {
        return "Авторизовались";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Привет, Админ!";
    }
}

