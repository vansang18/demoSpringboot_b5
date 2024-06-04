package com.example.demo_b5.Controller;

import com.example.demo_b5.Entities.User;
import com.example.demo_b5.RequestEntities.UserCreate;
import com.example.demo_b5.RequestEntities.UserEdit;
import com.example.demo_b5.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userServices;
    @GetMapping("")
    public String getAllUser(Model model)
    {
        List<User> users =userServices.getAllUser();
        model.addAttribute("users", users);
        return "User/getAll";
    }

    @GetMapping("/new")
    public String addUser(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "User/add";
    }

    @PostMapping("/save")
    public String saveUser(UserCreate userCreate){
        userServices.createUser(userCreate);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable String id, Model model)
    {
        User user = userServices.getUserById(id);
        model.addAttribute("user", user);
        return "User/edit";
    }

    @PostMapping("saveedit")
    public String saveUserEdit(UserEdit userEdit)
    {
        userServices.UpdateUser(userEdit);
        return "redirect:/users";
    }

    @GetMapping("/findemail")
    public String findemail(Model model){
        User user =userServices.findUserByEmail("admin@gmail.com");
        model.addAttribute("user", user);
        return "User/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id)
    {
        userServices.DeleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable String id, Model model){
        User user = userServices.getUserById(id);
        model.addAttribute("user", user);
        return "User/view";
    }
}
