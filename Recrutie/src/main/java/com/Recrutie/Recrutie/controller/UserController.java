package com.Recrutie.Recrutie.controller;

import com.Recrutie.Recrutie.dto.UserDto;
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

    @GetMapping("/get/{id}")
    public UserDto getUserById(@PathVariable Long id){
        return this.userService.getUserById(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("/register")
    public UserDto createUser(@Valid @RequestBody User user){
        return this.userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public UserDto updateUser(@Valid @PathVariable Long id, @RequestBody User user){
        return this.userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@Valid @PathVariable Long id){
        this.userService.deleteUser(id);
    }

    @PatchMapping("/update/status/{id}")
    public UserDto updateStatus(@Valid @PathVariable Long id, @RequestBody User user){
        return this.userService.updateStatus(id,user);
    }

    @PatchMapping("/update/role/{id}")
    public UserDto updateUserRole(@Valid @PathVariable Long id, @PathVariable Long roleId)  {
        return this.userService.updateUserRole(id,roleId);
    }
}
