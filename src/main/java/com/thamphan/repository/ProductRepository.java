package com.thamphan.repository;

import com.thamphan.model.Product;
import com.thamphan.service.GeneralService;

public interface ProductRepository extends GeneralRepository<Product> {

    Product findById( int id);

    void update(int id, Product product);

    void remove(int id);
}
