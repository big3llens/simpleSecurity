package ru.markelov.simpleSecurity.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.markelov.simpleSecurity.entities.User;
import ru.markelov.simpleSecurity.services.UserService;

import java.security.Principal;

@RestController

@Slf4j
@RequiredArgsConstructor
public class DaoController {
    private final UserService userService;

    @GetMapping("/app/score/get/current")
    public String daoShowCurrentUser(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "authenticated: [name: " + user.getUsername() + ", score: " + user.getScore().getPoints() + "]";
    }

    @GetMapping("/app/score/inc")
    public String daoIncCurrentUser(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        userService.daoIncCurrentUser(user.getUsername());
        return "the score has been increased by 5";
    }

    @GetMapping("/app/score/dec")
    public String daoDecCurrentUser(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        userService.daoDecCurrentUser(user.getUsername());
        return "points have been reduced by 5";
    }

    @GetMapping("/app/score/get/{id}")
    public String daoGetUsersScoreById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return "selected user [name: " + user.getUsername() + ", score: " + user.getScore().getPoints() + "]";
    }


}
