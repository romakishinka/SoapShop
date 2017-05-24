package ru.vsu.soapshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vsu.soapshop.repository.OrderRepository;
import ru.vsu.soapshop.repository.RoleRepository;
import ru.vsu.soapshop.repository.UserRepository;
import ru.vsu.soapshop.model.Role;
import ru.vsu.soapshop.model.User;
import ru.vsu.soapshop.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Александр on 18.05.2017.
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
