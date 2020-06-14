package com.edu.zzuli.service;

import com.edu.zzuli.entity.AccountEmployee;
import com.edu.zzuli.entity.AccountSystem;

import java.util.List;

/**
 * @ClassName AccountSystemService
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 21:40
 */
public interface AccountSystemService {
    List<AccountSystem> findAll();

    void deleteById(long id);

    void saveOrUpdate(AccountSystem accountSystem);
}
