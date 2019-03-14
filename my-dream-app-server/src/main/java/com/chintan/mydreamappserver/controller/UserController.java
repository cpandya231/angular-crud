package com.chintan.mydreamappserver.controller;

import com.chintan.mydreamappserver.entity.User;
import com.chintan.mydreamappserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET
            ,produces = "application/json")
    List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET
            ,produces = "application/json")
    User getUserById(@PathVariable("id") Integer id){

        return userService.getUserById(id);
    }



    @RequestMapping(value = "/createUser", method = RequestMethod.POST
            , consumes = "application/json", produces = "application/json")
    User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT
            , consumes = "application/json", produces = "application/json")
    User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, produces = "application/json")
    ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
        String responseMessage=userService.deleteUser(id);
        ResponseEntity<User> responseEntity=new ResponseEntity<User>(new User(), HttpStatus.OK);

        return responseEntity;
    }




}
