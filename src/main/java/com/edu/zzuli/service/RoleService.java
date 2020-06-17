package com.edu.zzuli.service;

import com.edu.zzuli.entity.Role;
import com.edu.zzuli.vm.RoleVM;

import java.util.List;

/**
 * @Classname RoleService
 * @Description TODO
 * @Date 2020/6/14 15:14
 * @Created by cccp
 */
public interface RoleService {
    public List<Role> findAll();
    public Role findById(long id);
    public void deleteById(long id);
    public void saveOrUpdate(Role role);
}
