package com.example.demo2.service;

import com.example.demo2.entity.UserTesting;
import com.example.demo2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public String getUserName(int id){
        Optional<UserTesting>user=repository.findById(id);
        if(user.isPresent()){
            return user.get().getName();
        }
        else{
            return "unknown user";
        }
    }
}
