package com.Recrutie.Recrutie.controller;

import com.Recrutie.Recrutie.dto.RoleDto;
import com.Recrutie.Recrutie.model.Role;
import com.Recrutie.Recrutie.services.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/get/id")
    public RoleDto getById(Long id){
        return this.roleService.getRoleById(id);
    }

    @GetMapping
    public List<RoleDto> getAllRoles(){
        return this.roleService.getAllRoles();
    }

    @PostMapping("/create")
    public RoleDto createRole(@Valid @RequestBody Role role){
        System.out.println("hit controller");
        return this.roleService.createRole(role);
    }

    @PutMapping("/update/{id}")
    public RoleDto updateRole(@Valid @PathVariable Long id,@RequestBody Role role){
        return this.roleService.updateRole(id,role);
    }

    @DeleteMapping("delete/{id}")
    public void deleteRole(Long id){
        this.roleService.deleteRole(id);
    }

    @PatchMapping("/update/status/{id}")
    public RoleDto updateRoleStatus(@Valid @PathVariable Long id,@RequestBody Role role){
        return this.roleService.updateRoleStatus(id,role);
    }
}
