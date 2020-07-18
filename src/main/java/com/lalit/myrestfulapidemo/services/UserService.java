package com.lalit.myrestfulapidemo.services;

import com.lalit.myrestfulapidemo.domain.User;

import java.util.Set;

public interface UserService {
    Set<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
}
