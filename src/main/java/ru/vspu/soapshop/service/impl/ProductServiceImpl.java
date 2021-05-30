package ru.vspu.soapshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vspu.soapshop.model.Product;
import ru.vspu.soapshop.repository.ProductRepository;
import ru.vspu.soapshop.service.ProductService;

import java.util.List;

/**
 * Created by Roman Kishinka on 20.05.2021.
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
        return productRepository.findById(id);
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
