package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.AccountEmployeeMapper;
import com.edu.zzuli.dao.AccountSystemMapper;
import com.edu.zzuli.entity.AccountEmployee;
import com.edu.zzuli.entity.AccountSystem;
import com.edu.zzuli.service.AccountSystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AccountSystemService
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 21:38
 */
@Service
public class AccountSystemServiceImpl implements AccountSystemService {
    @Resource
    private AccountSystemMapper accountSystemMapper;


    @Override
    public List<AccountSystem> findAll() {
        return accountSystemMapper.selectByExample(null);
    }

    @Override
    public void deleteById(long id) {
        accountSystemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AccountSystem accountSystem) {
        if (accountSystem.getId()!=null){
            accountSystemMapper.updateByPrimaryKey(accountSystem);
        }else {
            accountSystemMapper.insert(accountSystem);
        }
    }
}
