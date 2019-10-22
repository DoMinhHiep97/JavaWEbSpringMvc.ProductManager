package com.thamphan.repository;

import com.thamphan.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {

    private static Map<Integer, Product> productList=new HashMap<>();
    {
        productList.put(0,new Product(0,"Da Huong",125000, "Beautiful of lady!"));
        productList.put(1,new Product(1,"LifeBoy-10.in.1",12000,"LifeBoy"));
        productList.put(2,new Product(2,"Xmen-LuxuryForBoss",65000,"X-men"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void add(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }
}
