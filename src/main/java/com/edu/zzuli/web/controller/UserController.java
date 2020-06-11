package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.User;
import com.edu.zzuli.entity.extend.UserExtend;
import com.edu.zzuli.service.UserService;
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
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("getUser")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(@RequestBody User user){
        System.out.println(user.getRealname());
        userService.saveOrUpdate(user);
        return "保存或者更新成功";
    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        userService.deleteById(id);
        return "删除成功";
    }

    /**
     * 查询所有用户，并且级连获得用户角色
     * @return
     */
    @GetMapping("findAllWithRole")
    public List<UserExtend> findAllWithRole(){
        return userService.findAllWithRole();
    }
}
