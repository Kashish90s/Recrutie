package com.Recrutie.Recrutie.dto;


import com.Recrutie.Recrutie.Enum.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;
    private String email;
    private RoleDto role;
    private String phone;
    private boolean isVerified;
    private UserStatus status;

}
