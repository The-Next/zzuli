package com.edu.zzuli.service;

import com.edu.zzuli.entity.Order;
import com.edu.zzuli.entity.extend.OrderExtend;
import com.edu.zzuli.utils.CustomerException;
import com.edu.zzuli.vm.OrderVM;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description todo
 * @Author CY
 * @Date 2020/06/13 9:13
 */
public interface OrderService {

    void commit(OrderVM orderVM) throws CustomerException;

    List<Order> findAll();

    OrderExtend findOrderDetailsById(long id);
}
