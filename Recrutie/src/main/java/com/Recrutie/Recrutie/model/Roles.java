package com.Recrutie.Recrutie.model;

import com.Recrutie.Recrutie.Enum.RoleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleStatus status = RoleStatus.ACTIVE;
}
