package com.Recrutie.Recrutie.services;

import com.Recrutie.Recrutie.dto.RoleDto;
import com.Recrutie.Recrutie.model.Role;

import java.util.List;

public interface RoleService {
    RoleDto getRoleById(Long id);
    List<RoleDto> getAllRoles();
    RoleDto createRole(Role role);
    RoleDto updateRole(Long id, Role role);
    void deleteRole(Long id);
    RoleDto updateRoleStatus(Long id, Role status);
}
