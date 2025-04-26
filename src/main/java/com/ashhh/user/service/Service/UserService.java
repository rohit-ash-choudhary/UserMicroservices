package com.ashhh.user.service.Service;

import com.ashhh.user.service.entity.User;

import java.util.List;

public interface UserService {

    //create user
    public User saveUser(User user);

    //getalluser
    public List<User> getAluser();

    //getuserbyID
    public User getUserByID(String user_id);


    //update user by id
    public User updateUser(String user_id);

    //delete user id
    public boolean deleteUser(String user_id);

}
