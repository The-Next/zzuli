package com.edu.zzuli.service;

import com.edu.zzuli.entity.AccountCustomer;
import com.edu.zzuli.entity.AccountEmployee;

import java.util.List;

/**
 * @ClassName AccountCustomerService
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 21:08
 */
public interface AccountEmployeeService {
    List<AccountEmployee> findAll();
    void deleteById(long id);
    void saveOrUpdate(AccountEmployee accountEmployee);
}
