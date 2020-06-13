package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.Category;
import com.edu.zzuli.entity.extend.CategoryExtend;
import com.edu.zzuli.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname CategoryController
 * @Description TODO
 * @Date 2020/6/11 20:44
 * @Created by cccp
 */
@RestController
@RequestMapping("/category")
@Api(description = "")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.findAll();
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@RequestBody Category category){
        categoryService.saveOrUpdate(category);
        return "保存或者更新成功";
    }

    @ApiOperation("通过ID删除产品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "唯一编号", required = true, paramType = "query")
    })
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        categoryService.deleteById(id);
        return "删除成功";
    }

    @GetMapping("/findAllWithChild")
    public List<CategoryExtend> findAllWithChild(){
        return categoryService.findAllWithChild();
    }
}
