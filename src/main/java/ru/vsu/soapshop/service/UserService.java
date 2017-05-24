package ru.vsu.soapshop.service;

import ru.vsu.soapshop.model.User;

import java.util.List;

/**
 * Created by Александр on 18.05.2017.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
    List<User> getAllUsers();
}
