package com.chintan.mydreamappserver.serviceImpl;

import com.chintan.mydreamappserver.dao.UserRepository;
import com.chintan.mydreamappserver.entity.User;
import com.chintan.mydreamappserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        System.out.println(user);
        return userRepository.save(user);

    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> optionalResponse = userRepository.findById(id);
        if (optionalResponse.isPresent()) {
            return optionalResponse.get();
        }
        return new User();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> responseList = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            responseList.add(user);
        });
        return responseList;
    }

    @Override
    public User updateUser(User user) {
        if(userRepository.existsById(user.getId())){
            return userRepository.save(user);
        }
        return new User();

    }

    @Override
    public String deleteUser(Integer id) {

        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User Deleted";
        }

        return "User does not exist";
    }
}
