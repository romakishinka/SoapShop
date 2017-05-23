package ru.vsu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.soapshop.model.User;

/**
 * Created by Александр on 18.05.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
