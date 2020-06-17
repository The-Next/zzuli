package com.edu.zzuli.service;

import com.edu.zzuli.entity.Category;
import com.edu.zzuli.entity.Privilege;
import com.edu.zzuli.entity.extend.CategoryExtend;
import com.edu.zzuli.entity.extend.PrivilegeExtend;

import java.util.List;

/**
 * @Classname PrivilegeService
 * @Description TODO
 * @Date 2020/6/14 13:26
 * @Created by cccp
 */
public interface PrivilegeService {
    List<Privilege> findAll();
    void saveOrUpdate(Privilege privilege);
    void deleteById(long id);
    List<PrivilegeExtend> findAllWithChild();
    Privilege findWithRole(long id);
}
