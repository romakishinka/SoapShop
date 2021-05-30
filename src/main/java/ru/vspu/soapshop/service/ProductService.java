package ru.vspu.soapshop.service;

import ru.vspu.soapshop.model.Product;

import java.util.List;

/**
 * Created by Roman Kishinka on 20.05.2021.
 */
public interface ProductService {
    List<Product> getAllProducts();
    void deleteProduct(Long id);
    Product getProduct(Long id);
    void editProduct(Product product);
    void addProduct(Product product);

}
