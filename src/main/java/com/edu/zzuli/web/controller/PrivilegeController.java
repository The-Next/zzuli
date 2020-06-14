package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.Category;
import com.edu.zzuli.entity.Privilege;
import com.edu.zzuli.entity.extend.CategoryExtend;
import com.edu.zzuli.entity.extend.PrivilegeExtend;
import com.edu.zzuli.service.CategoryService;
import com.edu.zzuli.service.PrivilegeService;
import com.edu.zzuli.utils.Message;
import com.edu.zzuli.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname PrivilegeController
 * @Description TODO
 * @Date 2020/6/14 14:55
 * @Created by cccp
 */
@RestController
@RequestMapping("/privilege")
@Api(description = "权限管理接口")
public class PrivilegeController {
    @Resource
    private PrivilegeService privilegeService;


    @GetMapping("/getAll")
    public Message getAll(){
        List<Privilege> list = privilegeService.findAll();
        return MessageUtil.success(list);
    }

    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Privilege privilege){
        privilegeService.saveOrUpdate(privilege);
        return MessageUtil.success("保存或者更新成功");
    }

    @ApiOperation("通过ID删除权限信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "唯一编号", required = true, paramType = "query")
    })
    @GetMapping("/deleteById/{id}")
    public Message deleteById(@PathVariable("id") long id){
        privilegeService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("/findAllWithChild")
    public Message findAllWithChild(){
        List<PrivilegeExtend> list = privilegeService.findAllWithChild();
        return MessageUtil.success(list);
    }
}
