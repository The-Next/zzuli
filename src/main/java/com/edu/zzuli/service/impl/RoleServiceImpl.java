package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.PrivilegeMapper;
import com.edu.zzuli.dao.RoleMapper;
import com.edu.zzuli.dao.RolePrivilegeMapper;
import com.edu.zzuli.entity.*;
import com.edu.zzuli.entity.extend.PrivilegeExtend;
import com.edu.zzuli.service.PrivilegeService;
import com.edu.zzuli.service.RoleService;
import com.edu.zzuli.vm.RoleVM;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname RoleServiceImpl
 * @Description TODO
 * @Date 2020/6/14 15:19
 * @Created by cccp
 */
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RolePrivilegeMapper rolePrivilegeMapper;
    @Resource
    private PrivilegeMapper privilegeMapper;
    @Override
    public List<Role> findAll() {//查询角色带权限
//        List<RoleVM> roleVMS = new ArrayList<>();
        List<Role> roleList = roleMapper.selectByExample(null);
        for (Role role:roleList){
            role = roleMapper.findRoleWithPrivile(role.getId());
//            RolePrivilegeExample rolePrivilegeExample = new RolePrivilegeExample();
//            rolePrivilegeExample.createCriteria().andRoleIdEqualTo(role.getId());
//            List<RolePrivilege> list = rolePrivilegeMapper.selectByExample(rolePrivilegeExample);
//            List<Long> collect = list.stream().map(RolePrivilege::getPrivilegeId).collect(Collectors.toList());
//            PrivilegeExample privilegeExample = new PrivilegeExample();
//            privilegeExample.createCriteria().andIdIn(collect);
//            roleVMS.add(new RoleVM(role,privilegeMapper.selectByExample(privilegeExample)));
        }
        return roleList;
    }

    @Override
    public Role findById(long id) {
//        RoleVM vm = new RoleVM();
//        Role role = roleMapper.selectByPrimaryKey(id);
//        RolePrivilegeExample example = new RolePrivilegeExample();
//        example.createCriteria().andRoleIdEqualTo(role.getId());
//        List<RolePrivilege> rolePrivilege = rolePrivilegeMapper.selectByExample(example);
//        List<Long> collect = rolePrivilege.stream().map(RolePrivilege::getPrivilegeId).collect(Collectors.toList());
//        PrivilegeExample privilegeExample = new PrivilegeExample();
//        privilegeExample.createCriteria().andIdIn(collect);
//        List<Privilege> privilegeList = privilegeMapper.selectByExample(privilegeExample);
//        vm.setRole(role);
//        vm.setPrivileges(privilegeList);
        Role role = roleMapper.findRoleWithPrivile(id);
        return role;
    }

    @Override
    public void deleteById(long id) {
        roleMapper.deleteByPrimaryKey(id);
        RolePrivilegeExample example = new RolePrivilegeExample();
        example.createCriteria().andRoleIdEqualTo(id);
        rolePrivilegeMapper.deleteByExample(example);
    }

    @Override
    public void saveOrUpdate(Role role) {
        if (role.getId()!=null){
            roleMapper.updateByPrimaryKey(role);
        }else {
            roleMapper.insert(role);
        }
    }
}
