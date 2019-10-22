package com.thamphan.service;

import com.thamphan.model.Product;

public interface ProductService extends GeneralService<Product> {

    Product findByIdHaveBusiness( int id);

    void updateHaveBusiness(int id, Product product);

    void removeHaveBusiness(int id);
}
