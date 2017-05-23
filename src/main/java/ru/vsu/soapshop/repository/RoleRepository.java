package ru.vsu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.soapshop.model.Role;

/**
 * Created by Александр on 18.05.2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
