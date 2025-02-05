package com.Recrutie.Recrutie.controller;

import com.Recrutie.Recrutie.model.User;
import com.Recrutie.Recrutie.services.AuthService;
import com.Recrutie.Recrutie.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return authService.verify(user);
    }
}
