package com.familycircle.service;

import com.familycircle.model.User;

public interface UserService {
    User findByUsername(String username);
    void saveUser(User user);
    void registerUser(User user);  // Include this
}
