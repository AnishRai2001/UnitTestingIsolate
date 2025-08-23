package com.example.demo2.repository;

import com.example.demo2.entity.UserTesting;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository {
    Optional<UserTesting> findById(int id);
}
