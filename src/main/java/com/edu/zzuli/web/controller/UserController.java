package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.Product;
import com.edu.zzuli.entity.User;
import com.edu.zzuli.entity.extend.UserExtend;
import com.edu.zzuli.service.UserService;
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
 * @Classname UserController
 * @Description TODO
 * @Date 2020/6/11 20:58
 * @Created by cccp
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户管理接口")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("getUser")
    public Message findAll(){
        List<User> list = userService.findAll();
        return MessageUtil.success(list);
    }

    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(@RequestBody User user){
        userService.saveOrUpdate(user);
        return MessageUtil.success("保存或者更新成功");
    }

    @ApiOperation("通过ID删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "唯一编号", required = true, paramType = "query")
    })
    @GetMapping("deleteById")
    public Message deleteById(long id){
        userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    /**
     * 查询所有用户，并且级连获得用户角色
     * @return
     */
    @GetMapping("findAllWithRole")
    public Message findAllWithRole(){
        List<UserExtend> list = userService.findAllWithRole();
        return MessageUtil.success(list);
    }

    @GetMapping("/getUserId")
    public Message getUserById(Long id){
        User user = userService.selectUserById(id);
        return MessageUtil.success(user);
    }
}
