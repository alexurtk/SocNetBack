package com.socnet.back.persistence.service;

import com.socnet.back.persistence.model.PostModel;
import com.socnet.back.persistence.model.UserModel;

import java.util.List;


public interface UserService {
    void save(UserModel user);
//    void update(UserModel user);
    UserModel getUserByEmail(String email);
    List<UserModel> getAllUsers();
}
