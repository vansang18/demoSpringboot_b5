package com.example.demo_b5.Services;

import com.example.demo_b5.Entities.Role;
import com.example.demo_b5.Repositories.RoleRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServices {
    @Autowired
    private RoleRepsitory roleRepsitory;

    public List<Role> getAllRoles() {
        return roleRepsitory.findAll();
    }

    public void addRole(Role role)
    {
        roleRepsitory.save(role);
    }
}
