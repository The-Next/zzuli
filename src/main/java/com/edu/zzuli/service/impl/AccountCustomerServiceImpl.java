package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.AccountCustomerMapper;
import com.edu.zzuli.entity.AccountCustomer;
import com.edu.zzuli.service.AccountCustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AccountCustomerServiceImpl
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 21:08
 */
@Service
public class AccountCustomerServiceImpl implements AccountCustomerService {
    @Resource
    private AccountCustomerMapper accountCustomerMapper;


    @Override
    public List<AccountCustomer> findAll() {
        return accountCustomerMapper.selectByExample(null);
    }

    @Override
    public void deleteById(long id) {
        accountCustomerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(AccountCustomer accountCustomer) {

    }
}
