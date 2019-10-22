package com.thamphan.service;

import com.thamphan.model.Product;

import java.util.List;

public interface GeneralService<E> {
    List<E> findAllHaveBusiness();

    void addHaveBusiness(E e);
}
