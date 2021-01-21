package ru.markelov.simpleSecurity.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.markelov.simpleSecurity.entities.User;
import ru.markelov.simpleSecurity.services.UserService;

import java.security.Principal;

@RestController

@Slf4j
@RequiredArgsConstructor
public class DaoController {
    private final UserService userService;

    @GetMapping("/dao")
    public String daoTestPage(Principal principal) {
        // Authentication a = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "authenticated: " + user.getUsername() + " : " ;
    }
}
