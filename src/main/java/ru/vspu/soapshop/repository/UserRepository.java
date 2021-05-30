package ru.vspu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vspu.soapshop.model.User;

/**
 * Created by Roman Kishinka on 18.05.2021.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
