package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.AccountEmployeeMapper;
import com.edu.zzuli.entity.AccountEmployee;
import com.edu.zzuli.service.AccountEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AccountEmployeeServiceImpl
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 21:15
 */
@Service
public class AccountEmployeeServiceImpl implements AccountEmployeeService {
    @Resource
    private AccountEmployeeMapper accountEmployeeMapper;


    @Override
    public List<AccountEmployee> findAll() {
        return accountEmployeeMapper.selectByExample(null);
    }

    @Override
    public void deleteById(long id) {
        accountEmployeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AccountEmployee accountEmployee) {
        if (accountEmployee.getId()!=null){
            accountEmployeeMapper.updateByPrimaryKey(accountEmployee);
        }else {
            accountEmployeeMapper.insert(accountEmployee);
        }
    }
}
