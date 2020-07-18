package com.lalit.myrestfulapidemo.bootstrap;

import com.lalit.myrestfulapidemo.domain.User;
import com.lalit.myrestfulapidemo.repositories.UserRepository;
import com.lalit.myrestfulapidemo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserService userService;

    public bootstrap(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public void loadData(){
        User user = new User("Lalit", "Chilka");
        userRepository.save(user);
        User user1 = new User("Kadu", "Chilka");
        userRepository.save(user1);
        User user2 = new User("xyd", "pwq");
        userRepository.save(user2);

    }

    @Override
    public void run(String... args) throws Exception {
        if(userService.getAllUsers().size() == 0) loadData();
    }
}
