package com.example.demo_b5.RequestEntities;

import com.example.demo_b5.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreate {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthDay;
    private Role role ;
}
