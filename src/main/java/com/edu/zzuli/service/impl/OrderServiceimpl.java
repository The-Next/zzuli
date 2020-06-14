package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.OrderLineMapper;
import com.edu.zzuli.dao.OrderMapper;
import com.edu.zzuli.dao.extend.OrderExtendMapper;
import com.edu.zzuli.entity.Order;
import com.edu.zzuli.entity.OrderExample;
import com.edu.zzuli.entity.OrderLine;
import com.edu.zzuli.entity.extend.OrderExtend;
import com.edu.zzuli.service.OrderService;
import com.edu.zzuli.utils.CustomerException;
import com.edu.zzuli.vm.OrderVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description todo
 * @Author CY
 * @Date 2020/06/13 9:13
 */
@Service
public class OrderServiceimpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderLineMapper orderLineMapper;
    @Resource
    private OrderExtendMapper orderExtendMapper;

    @Override
    public void commit(OrderVM orderVM) throws CustomerException {
        /*
         *1.分别获取到订单信息 及订单项信息
         * 2.先保存订单信息
         * 3.保存订单项信息
         */
        Order order = new Order();
        order.setTotal(orderVM.getTotal());
        order.setAddressId(orderVM.getAddressId());
        order.setCustomerId(orderVM.getCustomerId());
        order.setEmployeeId(orderVM.getEmployeeId());
        order.setOrderTime(new Date().getTime());
        order.setStatus(OrderExtend.STATUS_WFK);

        List<OrderLine> orderLines = orderVM.getOrderLines();
        orderMapper.insert(order);
        for (OrderLine orderLine:orderLines){
            //设置order与orderLine之间的关键（外键维护）
            orderLine.setOrderId(order.getId());
            orderLineMapper.insert(orderLine);
        }

    }

    @Override
    public List<Order> findAll() {

        return orderMapper.selectByExample(new OrderExample());
    }

    @Override
    public List<Order> findByCustomer(long customerid, String status) {
        OrderExample example = new OrderExample();
        example.createCriteria().andCustomerIdEqualTo(customerid).andStatusEqualTo(status);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> findByWaiter(long waiterid, String status) {
        OrderExample example = new OrderExample();
        example.createCriteria().andEmployeeIdEqualTo(waiterid).andStatusEqualTo(status);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> findByAddress(long addressid) {
        OrderExample example = new OrderExample();
        example.createCriteria().andAddressIdEqualTo(addressid);
        return orderMapper.selectByExample(example);
    }

    @Override
    public OrderExtend findOrderDetailsById(long id){
        return orderExtendMapper.selectById(id);
    }
}
