package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.CategoryMapper;
import com.edu.zzuli.dao.extend.CategoryExtendMapper;
import com.edu.zzuli.entity.Category;
import com.edu.zzuli.entity.extend.CategoryExtend;
import com.edu.zzuli.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname CategoryServiceImpl
 * @Description TODO
 * @Date 2020/6/11 20:34
 * @Created by cccp
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private CategoryExtendMapper categoryExtendMapper;
    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    public void saveOrUpdate(Category category) {
        if (category.getId()!=null){
            categoryMapper.updateByPrimaryKey(category);
        }else {
            categoryMapper.insert(category);
        }
    }

    @Override
    public void deleteById(long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryExtend> findAllWithChild() {
        return categoryExtendMapper.selectAllWithChild();
    }
}
