package com.edu.zzuli.service;

import com.edu.zzuli.entity.User;
import com.edu.zzuli.entity.extend.UserExtend;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2020/6/11 20:54
 * @Created by cccp
 */
public interface UserService {
    public List<UserExtend> findAllEmployee();
    List<User> findAll();

    void saveOrUpdate(User user);

    void deleteById(long id);

    List<UserExtend> findAllWithRole();

    User selectUserById(Long id);
}
