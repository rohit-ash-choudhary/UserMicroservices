package com.ashhh.user.service.Service.imp;

import com.ashhh.user.service.Exception.ResourceNotFoundException;
import com.ashhh.user.service.Repository.UserRepository;
import com.ashhh.user.service.Service.UserService;
import com.ashhh.user.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userrepository;

    @Override
    public User saveUser(User user) {
        String random_user_id= UUID.randomUUID().toString();
        user.setUser_id(random_user_id);
        return userrepository.save(user);
    }

    @Override
    public List<User> getAluser() {
        return userrepository.findAll();
    }

    @Override
    public User getUserByID(String user_id) {
       return userrepository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User doesn't exists"));

    }

    @Override
    public User updateUser(String user_id) {
        return userrepository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User doesn't exists"));
    }

    @Override
    public boolean deleteUser(String user_id) {
        return false;
    }
}
