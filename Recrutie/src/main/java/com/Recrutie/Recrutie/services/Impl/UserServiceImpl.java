package com.Recrutie.Recrutie.services.Impl;

import com.Recrutie.Recrutie.dto.UserDto;
import com.Recrutie.Recrutie.exception.EmailAlreadyExistException;
import com.Recrutie.Recrutie.exception.UserNotFoundException;
import com.Recrutie.Recrutie.mapper.UserMapper;
import com.Recrutie.Recrutie.model.User;
import com.Recrutie.Recrutie.repository.UserRepository;
import com.Recrutie.Recrutie.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Override
    public UserDto getUserById(Long id) {
        User user = this.userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User doesn't exist"));
        return userMapper.toUserDto(user);
    }

    @Override
    public boolean getUserByEmail(String email) {
        User user =  this.userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        }
        return users.stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(User user){
        if(getUserByEmail(user.getEmail())){
            throw new EmailAlreadyExistException("Email already taken");
        }
            user.setPassword(encoder.encode(user.getPassword()));

            User newUser = this.userRepository.save(user);
            return userMapper.toUserDto(newUser);

    }

    @Override
    public UserDto updateUser(Long id, User user) {
        User existingUser = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setStatus(user.getStatus());
        existingUser.setVerified(user.isVerified());

        User updatedUser = this.userRepository.save(existingUser);
        return userMapper.toUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id){
        User user = this.userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found"));
        this.userRepository.delete(user);
    }

}
