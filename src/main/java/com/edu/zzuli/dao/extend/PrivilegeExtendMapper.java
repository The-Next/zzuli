package com.edu.zzuli.dao.extend;

import com.edu.zzuli.entity.extend.CategoryExtend;
import com.edu.zzuli.entity.extend.PrivilegeExtend;

import java.util.List;

/**
 * @Classname PrivilegeExtendMapper
 * @Description TODO
 * @Date 2020/6/14 13:20
 * @Created by cccp
 */
public interface PrivilegeExtendMapper {
    List<PrivilegeExtend> selectAllWithChild();
}
