package com.celsoaquino.jwt.api.repository;

import com.celsoaquino.jwt.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String s);
}
