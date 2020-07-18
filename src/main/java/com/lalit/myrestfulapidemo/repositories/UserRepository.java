package com.lalit.myrestfulapidemo.repositories;

import com.lalit.myrestfulapidemo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
