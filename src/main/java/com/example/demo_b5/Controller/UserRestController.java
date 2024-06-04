package com.example.demo_b5.Controller;

import com.example.demo_b5.Entities.User;
import com.example.demo_b5.RequestEntities.UserCreate;
import com.example.demo_b5.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private UserServices userServices;
    @GetMapping("")
    public List<User> getAllUsers() {
        return userServices.getAllUser();
    }

    @PostMapping("")
    public User createUser(@RequestBody UserCreate userCreate)
    {
        return userServices.createUser(userCreate);
    }
}
