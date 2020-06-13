package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.ProductMapper;
import com.edu.zzuli.dao.extend.ProductExtendMapper;
import com.edu.zzuli.entity.Product;
import com.edu.zzuli.entity.extend.ProductExtend;
import com.edu.zzuli.service.ProductService;
import com.edu.zzuli.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname ProductServiceImpl
 * @Description TODO
 * @Date 2020/6/11 20:04
 * @Created by cccp
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductExtendMapper productExtendMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.selectByExample(null);
    }

    @Override
    public void saveOrUpdate(Product product) {
        if (product.getId()!=null){
            productMapper.updateByPrimaryKey(product);
        }else {
            productMapper.insert(product);
        }
    }

    @Override
    public void deleteById(long id) throws ClassCastException{
        Product product = productMapper.selectByPrimaryKey(id);
        if (product==null){
            throw new CustomerException("删除失败，要删除的数据不存在");
        }else {
            productMapper.deleteByPrimaryKey(id);
        }
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ProductExtend> findAllWithCategory() {
        return productExtendMapper.selectAllWithCategory();
    }

    @Override
    public Product selectProductById(long id) {
        return productMapper.selectByPrimaryKey(id);
    }
}
