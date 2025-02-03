package com.Recrutie.Recrutie.mapper;

import com.Recrutie.Recrutie.dto.RoleDto;
import com.Recrutie.Recrutie.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toRoleDto(Role role);

    Role toRole(RoleDto roleDto);
}
