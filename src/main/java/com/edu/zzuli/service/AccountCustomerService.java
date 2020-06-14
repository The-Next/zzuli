package com.edu.zzuli.service;

import com.edu.zzuli.entity.AccountCustomer;

import java.util.List;

/**
 * @ClassName AccountCustomerService
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 21:08
 */
public interface AccountCustomerService {
    List<AccountCustomer> findAll();
    void deleteById(long id);
    void saveOrUpdate(AccountCustomer accountCustomer);
}
