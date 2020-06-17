package com.edu.zzuli.dao.extend;

import com.edu.zzuli.entity.extend.UserExtend;

import java.util.List;

/**
 * @Classname UserExtendMapper
 * @Description TODO
 * @Date 2020/6/11 20:52
 * @Created by cccp
 */
public interface UserExtendMapper {
    List <UserExtend> selectAllEmployee();
    List<UserExtend> selectAllWithRole();
}