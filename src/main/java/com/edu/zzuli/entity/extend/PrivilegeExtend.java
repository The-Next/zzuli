package com.edu.zzuli.entity.extend;

import com.edu.zzuli.entity.Privilege;

import java.util.List;

/**
 * @Classname PrivilegeExtend
 * @Description TODO
 * @Date 2020/6/14 13:15
 * @Created by cccp
 */
public class PrivilegeExtend extends Privilege {
    List<Privilege> children;

    public List<Privilege> getChildren() {
        return children;
    }

    public void setChildren(List<Privilege> children) {
        this.children = children;
    }
}
