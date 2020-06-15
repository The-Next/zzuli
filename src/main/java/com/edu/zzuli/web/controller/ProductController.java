package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.Product;
import com.edu.zzuli.entity.extend.ProductExtend;
import com.edu.zzuli.service.ProductService;
import com.edu.zzuli.utils.Message;
import com.edu.zzuli.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@Api(description = "产品管理接口")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/getProduct")
    public Message getAllProduct(){
        ArrayList<Product> arrayList= (ArrayList<Product>) productService.findAll();
        return MessageUtil.success(arrayList);
    }

    @GetMapping("/getProductById")
    public Message getProductById(Long id){
        Product product = productService.selectProductById(id);
        return MessageUtil.success(product);
    }

    @PostMapping("/saveOrUpdateProuct")
    public Message saveOrUpdateProuct(@RequestBody Product product){
        productService.saveOrUpdate(product);
        return MessageUtil.success("保存成功");
    }


    @ApiOperation("通过ID删除产品信息")
    @GetMapping("/deleteProduct")
    public Message deleteProductById( Long id){
        productService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("/findAllWithCategory")
    public Message findAllWithCategory(){
        List<ProductExtend> list=productService.findAllWithCategory();
        return MessageUtil.success(list);
    }
}
