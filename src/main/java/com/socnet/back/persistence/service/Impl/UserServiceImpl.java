package com.socnet.back.persistence.service.Impl;

import com.socnet.back.persistence.model.PostModel;
import com.socnet.back.persistence.model.UserModel;
import com.socnet.back.persistence.repository.PostRepository;
import com.socnet.back.persistence.repository.UserRepository;
import com.socnet.back.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserModel user) {
        userRepository.save(user);
    }

//    @Override
//    public void update(UserModel user) {
////        UserModel oldUser = userRepository.getOne(user.getId());
//        userRepository.save(user);
//    }

    @Override
    public UserModel getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
}
