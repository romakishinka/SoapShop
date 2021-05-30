package ru.vspu.soapshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vspu.soapshop.repository.OrderRepository;
import ru.vspu.soapshop.repository.RoleRepository;
import ru.vspu.soapshop.repository.UserRepository;
import ru.vspu.soapshop.model.Role;
import ru.vspu.soapshop.model.User;
import ru.vspu.soapshop.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Roman Kishinka on 18.05.2021.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1L));
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
