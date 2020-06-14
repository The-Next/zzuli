package com.edu.zzuli.service;

import com.edu.zzuli.entity.OrderLine;

import java.util.List;

/**
 * @Classname OrderLineService
 * @Description TODO
 * @Date 2020/6/14 17:44
 * @Created by cccp
 */
public interface OrderLineService {
    public List<OrderLine> findByOrderId(long id);
    public List<OrderLine> findByProductId(long id);
}
