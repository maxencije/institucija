package com.example.institucija.service;

import com.example.institucija.domain.Role;
import com.example.institucija.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    User getUser(String username);
    List<User> getUsers();
}
