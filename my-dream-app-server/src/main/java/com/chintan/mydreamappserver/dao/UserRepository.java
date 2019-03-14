package com.chintan.mydreamappserver.dao;


import com.chintan.mydreamappserver.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends CrudRepository<User, Integer> {
}