package com.Recrutie.Recrutie.services.Impl;

import com.Recrutie.Recrutie.dto.RoleDto;
import com.Recrutie.Recrutie.mapper.RoleMapper;
import com.Recrutie.Recrutie.model.Role;
import com.Recrutie.Recrutie.repository.RoleRepository;
import com.Recrutie.Recrutie.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = this.roleRepository.findById(id).orElseThrow(()->new RuntimeException("Role doesn't exist"));
        return roleMapper.toRoleDto(role);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> role = this.roleRepository.findAll();
        if (role.isEmpty()){
            throw new RuntimeException("No roles");
        }
        return role.stream()
                .map(roleMapper::toRoleDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto createRole(Role role) {
        System.out.println("service");
        return roleMapper.toRoleDto(this.roleRepository.save(role));
    }

    @Override
    public RoleDto updateRole(Long id, Role role) {
        Role existingRole = this.roleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role doesn't exist"));
        existingRole.setName(role.getName());
        Role updatedRole = this.roleRepository.save(existingRole);
        return roleMapper.toRoleDto(updatedRole);
    }

    @Override
    public void deleteRole(Long id) {
        Role role = this.roleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role doesn't exist"));
        this.roleRepository.delete(role);
    }

    @Override
    public RoleDto updateRoleStatus(Long id, Role status) {
        Role role = this.roleRepository.findById(id).orElseThrow(()-> new RuntimeException("Role doesn't exist"));
        role.setStatus(status.getStatus());
        this.roleRepository.save(role);
        return roleMapper.toRoleDto(role);
    }
    //this comment is for checking commit notification on slack for branch dev
}
