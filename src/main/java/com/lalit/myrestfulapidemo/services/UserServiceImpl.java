package com.lalit.myrestfulapidemo.services;

import com.lalit.myrestfulapidemo.domain.User;
import com.lalit.myrestfulapidemo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> getAllUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(new User("Dummy", "User"));
    }

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }
}
