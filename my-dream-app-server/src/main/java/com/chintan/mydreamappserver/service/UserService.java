package com.chintan.mydreamappserver.service;

import com.chintan.mydreamappserver.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Integer id);

    List<User> getAllUsers();

    User updateUser(User user);

    String deleteUser(Integer id);
}
