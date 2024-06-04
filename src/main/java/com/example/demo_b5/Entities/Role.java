package com.example.demo_b5.Entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;
    @Column(nullable = false)
    private String role_Name;
    @Column(nullable = false)
    @OneToMany(mappedBy = "role")
    private List<User> users;

}
