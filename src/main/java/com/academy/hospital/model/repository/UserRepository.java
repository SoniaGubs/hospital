package com.academy.hospital.model.repository;

import com.academy.hospital.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String userName);
}
