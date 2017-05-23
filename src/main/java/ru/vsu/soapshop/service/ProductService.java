package ru.vsu.soapshop.service;

import ru.vsu.soapshop.model.Product;

import java.util.List;
import java.util.Set;

/**
 * Created by Александр on 20.05.2017.
 */
public interface ProductService {
    List<Product> getAllProducts();
    void deleteProduct(Long id);
    Product getProduct(Long id);
    void editProduct(Product product);
    void addProduct(Product product);

}
