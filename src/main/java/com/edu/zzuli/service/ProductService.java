package com.edu.zzuli.service;

import com.edu.zzuli.entity.Product;
import com.edu.zzuli.entity.extend.ProductExtend;

import java.util.List;

/**
 * @Classname ProductService
 * @Description TODO
 * @Date 2020/6/11 20:01
 * @Created by cccp
 */
public interface ProductService {
    List<Product> findAll();
    void saveOrUpdate(Product product) throws ClassCastException;
    void deleteById(long id) throws ClassCastException;
    List<ProductExtend> findAllWithCategory();
    Product selectProductById(long id);

    List<Product> findProductLike(String name);
}
