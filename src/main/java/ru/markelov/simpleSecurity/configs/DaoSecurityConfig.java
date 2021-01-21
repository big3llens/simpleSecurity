package ru.markelov.simpleSecurity.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.markelov.simpleSecurity.services.UserService;

@EnableWebSecurity
public class DaoSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserService userService;

    @Autowired
    public DaoSecurityConfig (UserService userService){
        this.userService = userService;
    }

}
