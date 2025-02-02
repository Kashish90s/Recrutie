package com.Recrutie.Recrutie.services;

import com.Recrutie.Recrutie.dto.UserDto;
import com.Recrutie.Recrutie.model.User;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long id);
    boolean getUserByEmail(String email);
    List<UserDto> getAllUsers();
    UserDto createUser(User user);
    UserDto updateUser(Long id,User user);
    void deleteUser(Long id);
}
