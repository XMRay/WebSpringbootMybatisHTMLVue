package com.test.demo2.controller;

import com.test.demo2.entity.User;
import com.test.demo2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public User getUser(@RequestParam("id") int id){
        return userService.queryUser(id);
    }

    @GetMapping("/addUser")
    public User addUser(@RequestParam("id") int id,@RequestParam("username") String username,@RequestParam("des") String des,@RequestParam("age") int age){
        return userService.queryaddUser(id,username,des,age);
    }

    @GetMapping("/changeUser")
    public User changeUser(@RequestParam("oldid") int oldid,@RequestParam("id") int id,@RequestParam("username") String username,@RequestParam("des") String des,@RequestParam("age") int age){
        return userService.querychangeUser(oldid,id,username,des,age);
    }

    @GetMapping("/delUser")
    public User delUser(@RequestParam("id") int id){
        return userService.queryDelUser(id);
    }

//    @GetMapping("/getUser2")
//    public List<User> getUser2(@RequestParam("age") int age){
//        return userService.queryUser2(age);
//    }

    @GetMapping("/getUserAll")
    public List<User> getUserAll(){
        return userService.queryUserAll();
    }
}
