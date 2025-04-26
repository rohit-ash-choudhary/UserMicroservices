package com.ashhh.user.service.Controller;


import com.ashhh.user.service.Service.UserService;
import com.ashhh.user.service.entity.User;
import org.apache.catalina.valves.HealthCheckValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userservice;

    //create user
    @PostMapping()
    public ResponseEntity<User>  createUser(@RequestBody User users){


                User user=userservice.saveUser(users);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //get single user
    @GetMapping("/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable String user_id)
    {

        User user=userservice.getUserByID(user_id);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }


    //get all user
    @GetMapping
    public ResponseEntity<List<User>> getaLLUser()
    {

        List<User> user=userservice.getAluser();
        return ResponseEntity.ok(user);

    }

    //update user



    //delete user
}
