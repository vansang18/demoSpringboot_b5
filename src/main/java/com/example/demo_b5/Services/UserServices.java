package com.example.demo_b5.Services;

import com.example.demo_b5.Entities.Role;
import com.example.demo_b5.Entities.User;
import com.example.demo_b5.Repositories.UserRepository;
import com.example.demo_b5.RequestEntities.UserCreate;
import com.example.demo_b5.RequestEntities.UserEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleServices roleServices;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> {
                    throw  new RuntimeException("Khong tim thay ID");
                }
        );
    }
    public User createUser(UserCreate userCreate){
       try{
           User user = new User();
           user.setFirstName(userCreate.getFirstName());
           user.setFirstName(userCreate.getFirstName());
           user.setFirstName(userCreate.getFirstName());
           user.setLastName(userCreate.getLastName());
           user.setEmail(userCreate.getEmail());
           user.setPassword(userCreate.getPassword());//yyyy-MM-dd
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           user.setBirthDay(dateFormat.parse(userCreate.getBirthDay()));
           userRepository.save(user);
           return user;
       }catch (Exception e){
           throw  new RuntimeException(e.getMessage());
       }
    }
    public User UpdateUser(UserEdit userEdit) throws RuntimeException {
        try{
            User user =getUserById(userEdit.getID());
            user.setFirstName(userEdit.getFirstName());
            user.setLastName(userEdit.getLastName());
            user.setEmail(userEdit.getEmail());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthDay(dateFormat.parse(userEdit.getBirthDay()));
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public void DeleteUser(String id){
        userRepository.deleteById(id);
    }
}
