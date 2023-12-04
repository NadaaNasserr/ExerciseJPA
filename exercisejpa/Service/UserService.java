package com.example.exercisejpa.Service;


import com.example.exercisejpa.Model.User;
import com.example.exercisejpa.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public List<User> getAllUser(){
        return userRepository.findAll();
    }


    public void addUser(User user){
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id , User user){

        User oldUser = userRepository.getById(id);
        if(oldUser==null){
            return false;
        }


        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setBalance(user.getBalance());
        oldUser.setCountOfPurchases(user.getCountOfPurchases());



        userRepository.save(oldUser);
        return true;
    }
    public Boolean deleteUser(Integer id){

        User user = userRepository.getById(id);
        if(user == null){
            return false;
        }
        userRepository.delete(user);
        return true;
    }



}



