package com.curiouscoder.service;

import com.curiouscoder.entity.User;
import com.curiouscoder.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    //Create user
    public User createUser(User user) {
        return userRepository.save(user);
    }


    //Update user
    public User updateUser(int id , User user) {

        User user1 = userRepository.findById(id).orElse(null);
        if(user1 != null) {
            return userRepository.save(user);
        }

        return null;
    }


    //Get by id
    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("No resource found " + id));
    }


    //Get all
    public List<User> allUsers() {
        return userRepository.findAll();
    }


    //Delete
    public boolean deleteUser(int id) {
         User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("No resource found " + id));
         if(user != null) {
             userRepository.deleteById(id);
             return true;
         }
         return false;
    }

}
