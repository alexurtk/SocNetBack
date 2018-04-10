package com.socnet.back.controller;

import com.socnet.back.persistence.model.PostModel;
import com.socnet.back.persistence.model.UserModel;
import com.socnet.back.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getByEmail/{email:.+}", method = RequestMethod.GET)
    public List<UserModel> getUser(@PathVariable("email") String email){
        UserModel user = userService.getUserByEmail(email);
        List<UserModel> users = new ArrayList<>();

        if (user != null)
            users.add(user);

        return users;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserModel createUser(@RequestBody UserModel user){
        userService.save(user);
        return user;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public UserModel updateUser(@RequestBody UserModel user){
        userService.save(user);
        return user;
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public List<UserModel> getAllUsers(){
        List<UserModel> users = userService.getAllUsers();
        return users;


//        @RequestMapping(value = "/getWallByOwner{owner}", method = RequestMethod.GET)
//        public List<PostModel> getWallByOwner(@PathVariable("owner") String owner){
//            PostModel user = userService.getWallByOwner(owner);
//            List<PostModel> wall = new ArrayList<>();
//
//            if (wall != null)
//                wall.add(wall);
//
//            return wall;
//        }
    }






}
