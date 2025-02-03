package com.Recrutie.Recrutie.mapper;


import com.Recrutie.Recrutie.dto.UserDto;
import com.Recrutie.Recrutie.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {RoleMapper.class})
public interface UserMapper{

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);
}
