package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.UserMapper;
import com.edu.zzuli.dao.extend.UserExtendMapper;
import com.edu.zzuli.entity.User;
import com.edu.zzuli.entity.UserExample;
import com.edu.zzuli.entity.extend.UserExtend;
import com.edu.zzuli.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserServiceimpl
 * @Description TODO
 * @Date 2020/6/11 20:55
 * @Created by cccp
 */
@Service
class UerServiceimpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserExtendMapper userExtendMapper;

    @Override
    public List<UserExtend> findAllEmployee() {
        return userExtendMapper.selectAllEmployee();
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public void saveOrUpdate(User user) {
        if (user.getId()!=null){
            userMapper.updateByPrimaryKey(user);
        }else {
            userMapper.insert(user);
        }
    }

    @Override
    public void deleteById(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<UserExtend> findAllWithRole() {
        return userExtendMapper.selectAllWithRole();
    }

    @Override
    public User selectUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findUserLike(String name) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andRealnameLike("%"+name+"%");
        return userMapper.selectByExample(userExample);
    }
}
