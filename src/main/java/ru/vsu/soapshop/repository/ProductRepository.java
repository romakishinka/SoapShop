package ru.vsu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.soapshop.model.Product;
import ru.vsu.soapshop.model.Role;

/**
 * Created by Александр on 20.05.2017.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
