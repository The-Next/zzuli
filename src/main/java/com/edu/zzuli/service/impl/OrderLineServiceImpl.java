package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.OrderLineMapper;
import com.edu.zzuli.entity.OrderExample;
import com.edu.zzuli.entity.OrderLine;
import com.edu.zzuli.entity.OrderLineExample;
import com.edu.zzuli.service.OrderLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname OrderLineServiceImpl
 * @Description TODO
 * @Date 2020/6/14 17:45
 * @Created by cccp
 */
@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Resource
    private OrderLineMapper orderLineMapper;
    @Override
    public List<OrderLine> findByOrderId(long id) {
        OrderLineExample orderLineExample = new OrderLineExample();
        orderLineExample.createCriteria().andOrderIdEqualTo(id);
        return orderLineMapper.selectByExample(orderLineExample);
    }

    @Override
    public List<OrderLine> findByProductId(long id) {
        OrderLineExample orderLineExample = new OrderLineExample();
        orderLineExample.createCriteria().andProductIdEqualTo(id);
        return orderLineMapper.selectByExample(orderLineExample);
    }
}
