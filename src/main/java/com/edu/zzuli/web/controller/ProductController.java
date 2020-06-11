package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.Product;
import com.edu.zzuli.entity.extend.ProductExtend;
import com.edu.zzuli.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/getProduct")
    public ArrayList<Product> getAllProduct(){
        return (ArrayList<Product>) productService.findAll();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.selectProductById(id);
    }

    @PostMapping("/saveOrUpdateProuct")
    public String saveOrUpdateProuct(@RequestBody Product product){
        productService.saveOrUpdate(product);
        return "插入或更新成功";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProductById(@PathVariable("id") Long id){
        productService.deleteById(id);
        return "删除成功";
    }

    @GetMapping("/findAllWithCategory")
    public List<ProductExtend> findAllWithCategory(){
        return productService.findAllWithCategory();
    }
}
