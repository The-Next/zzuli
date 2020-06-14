package com.edu.zzuli.service;

import com.edu.zzuli.entity.Address;
import com.edu.zzuli.entity.Category;
import com.edu.zzuli.entity.extend.CategoryExtend;

import java.util.List;

/**
 * @Classname AddressService
 * @Description TODO
 * @Date 2020/6/14 17:01
 * @Created by cccp
 */
public interface AddressService {
    void saveOrUpdate(Address address);
    void deleteById(long id);
    List<Address> findAllWithUserId(long id);
}
