package ru.vspu.soapshop.service;

import ru.vspu.soapshop.model.User;

import java.util.List;

/**
 * Created by Roman Kishinka on 18.05.2021.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
    List<User> getAllUsers();
}
