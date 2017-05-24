package ru.vsu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vsu.soapshop.model.Product;
import ru.vsu.soapshop.model.Role;

/**
 * Created by Александр on 20.05.2017.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select o from Product o where o.productId =:productId")
    Product findById(@Param("productId") Long productId);

}
