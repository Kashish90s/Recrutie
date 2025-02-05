package com.Recrutie.Recrutie.services.Impl;

import com.Recrutie.Recrutie.model.User;
import com.Recrutie.Recrutie.repository.UserRepository;
import com.Recrutie.Recrutie.services.AuthService;
import com.Recrutie.Recrutie.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final AuthenticationManager authManager;
    private final JWTService jwtService;


    @Override
    public String login(User user) {
        return "Success";
    }

    @Override
    public String verify(User user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getName());

        return "Fail";
    }
}
