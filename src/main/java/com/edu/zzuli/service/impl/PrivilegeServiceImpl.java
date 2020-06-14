package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.PrivilegeMapper;
import com.edu.zzuli.dao.extend.PrivilegeExtendMapper;
import com.edu.zzuli.entity.Privilege;
import com.edu.zzuli.entity.extend.PrivilegeExtend;
import com.edu.zzuli.service.PrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname PrivilegeServiceImpl
 * @Description TODO
 * @Date 2020/6/14 13:27
 * @Created by cccp
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Resource
    private PrivilegeMapper privilegeMapper;
    @Resource
    private PrivilegeExtendMapper privilegeExtendMapper;
    @Override
    public List<Privilege> findAll() {
        return privilegeMapper.selectByExample(null);
    }

    @Override
    public void saveOrUpdate(Privilege privilege) {
        if (privilege.getId()!=null){
            privilegeMapper.updateByPrimaryKey(privilege);
        }else {
            privilegeMapper.insert(privilege);
        }
    }

    @Override
    public void deleteById(long id) {
        privilegeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PrivilegeExtend> findAllWithChild() {
        return privilegeExtendMapper.selectAllWithChild();
    }
}
