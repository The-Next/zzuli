package com.edu.zzuli.service;

import com.edu.zzuli.entity.Category;
import com.edu.zzuli.entity.extend.CategoryExtend;

import java.util.List;

/**
 * @Classname CategoryService
 * @Description TODO
 * @Date 2020/6/11 20:33
 * @Created by cccp
 */
public interface CategoryService {
    List<Category> findAll();
    void saveOrUpdate(Category category);
    void deleteById(long id);
    List<CategoryExtend> findAllWithChild();
}
