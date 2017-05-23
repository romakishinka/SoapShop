package ru.vsu.soapshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.soapshop.model.Product;
import ru.vsu.soapshop.repository.ProductRepository;
import ru.vsu.soapshop.service.ProductService;

import java.util.List;
import java.util.Set;

/**
 * Created by Александр on 20.05.2017.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public void editProduct(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void addProduct(Product product) {
        productRepository.saveAndFlush(product);
    }
}
