package ru.vspu.soapshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vspu.soapshop.model.Product;

/**
 * Created by Roman Kishinka on 20.05.2021.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select o from Product o where o.productId =:productId")
    Product findById(@Param("productId") Long productId);

}
