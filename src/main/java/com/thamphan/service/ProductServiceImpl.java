package com.thamphan.service;

import com.thamphan.model.Product;
import com.thamphan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllHaveBusiness() {
        return productRepository.findAll();
    }

    @Override
    public void addHaveBusiness(Product product) {
        productRepository.add(product);

    }

    @Override
    public Product findByIdHaveBusiness(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateHaveBusiness(int id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void removeHaveBusiness(int id) {
        productRepository.remove(id);
    }
}
