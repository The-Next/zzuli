package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.AddressMapper;
import com.edu.zzuli.entity.Address;
import com.edu.zzuli.entity.AddressExample;
import com.edu.zzuli.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname AddressServiceImpl
 * @Description TODO
 * @Date 2020/6/14 17:03
 * @Created by cccp
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressMapper addressMapper;
    @Override
    public void saveOrUpdate(Address address) {
        if (address.getId()!=null){
            addressMapper.updateByPrimaryKey(address);
        }else {
            addressMapper.insert(address);
        }
    }

    @Override
    public void deleteById(long id) {
        addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Address> findAllWithUserId(long id) {
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andUserIdEqualTo(id);
        return addressMapper.selectByExample(addressExample);
    }
}
