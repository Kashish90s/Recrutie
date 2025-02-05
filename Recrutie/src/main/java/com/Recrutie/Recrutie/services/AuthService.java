package com.Recrutie.Recrutie.services;

import com.Recrutie.Recrutie.model.User;

public interface AuthService {

    String login(User user);

    String verify(User user);
}
