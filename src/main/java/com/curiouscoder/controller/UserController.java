package com.curiouscoder.controller;

import com.curiouscoder.entity.User;
import com.curiouscoder.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @MutationMapping
    public User createUser(@Argument String name , @Argument String email , @Argument String mobile) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setMobile(mobile);

        return userService.createUser(user);
    }


    @QueryMapping
    public List<User> getUsers() {
        return userService.allUsers();
    }


    @QueryMapping(name = "getUser")
    public User getSingleUser(@Argument int userId) {
        return userService.getById(userId);
    }


    @MutationMapping(name = "deleteUser")
    public Boolean deleteUser(@Argument int userId) {
        return userService.deleteUser(userId);
    }

}
