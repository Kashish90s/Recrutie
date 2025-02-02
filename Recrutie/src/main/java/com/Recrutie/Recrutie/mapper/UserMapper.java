package com.Recrutie.Recrutie.mapper;

import com.Recrutie.Recrutie.dto.RoleDto;
import com.Recrutie.Recrutie.dto.UserDto;
import com.Recrutie.Recrutie.model.Role;
import com.Recrutie.Recrutie.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper{


    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

    RoleDto toRoleDto(Role role);

    Role toRole(RoleDto roleDto);
}
