package com.example.authorization.service;

import com.example.authorization.models.Role;
import com.example.authorization.models.User;
import com.example.authorization.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }
    public User findByLoginAndPassword(String login, String password){
        return userRepository.findUserByLoginAndPassword(login, password);
    }
    public User findById(Long id){
       return userRepository.findUserById(id);
    }
    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }
}
