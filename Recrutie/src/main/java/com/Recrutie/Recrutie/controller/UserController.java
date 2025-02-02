package com.Recrutie.Recrutie.controller;

import com.Recrutie.Recrutie.dto.UserDto;
import com.Recrutie.Recrutie.mapper.UserMapper;
import com.Recrutie.Recrutie.model.User;
import com.Recrutie.Recrutie.services.Impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;
    private final UserMapper usermapper;

    @GetMapping("/get/{id}")
    public UserDto getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public UserDto createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public UserDto updateUser(@Valid @PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@Valid @PathVariable Long id){
        userService.deleteUser(id);
    }

}
