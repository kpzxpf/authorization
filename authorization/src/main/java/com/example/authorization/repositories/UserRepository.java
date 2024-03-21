package com.example.authorization.repositories;

import com.example.authorization.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    User findUserByLoginAndPassword(String login, String Password);
    String getRoleById(Long id);
}

