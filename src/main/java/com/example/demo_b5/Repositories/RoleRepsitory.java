package com.example.demo_b5.Repositories;

import com.example.demo_b5.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepsitory extends JpaRepository<Role, String> {
    @Query("SELECT r FROM Role r where r.role_Name=?1 ")
    Role findOneByName(String name);
}
