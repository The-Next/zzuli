package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.OrderLineMapper;
import com.edu.zzuli.dao.OrderMapper;
import com.edu.zzuli.dao.UserMapper;
import com.edu.zzuli.dao.extend.OrderExtendMapper;
import com.edu.zzuli.entity.Order;
import com.edu.zzuli.entity.OrderExample;
import com.edu.zzuli.entity.OrderLine;
import com.edu.zzuli.entity.User;
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
    @Resource
    private UserMapper userMapper;

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
    public List<OrderExtend> query(String status) {
        return orderExtendMapper.query(null,status);
    }

    @Override
    public OrderExtend findOrderDetailsById(long id){
        List<OrderExtend> list = orderExtendMapper.query(id,null);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void payOrder(long orderId) throws Exception {
        //支付
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order==null){
            throw new Exception("该订单不存在");
        }
        //待派单
        order.setStatus(OrderExtend.STATUS_DPD);
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void sendOrder(long orderId, long employeeId) throws Exception {
        //派单
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order==null){
            throw new Exception("订单不存在");
        }else if (!order.getStatus().equals("待派单")){
            throw new Exception("订单未支付/订单异常");
        }
        User emp = userMapper.selectByPrimaryKey(employeeId);
        if (emp==null){
            throw new Exception("该员工不存在");
        }
        //进入带服务状态
        order.setStatus(OrderExtend.STATUS_DFW);
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void rejectOrder(long orderId) throws Exception {
        //服务结束
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order==null){
            throw new Exception("该订单不存在");
        }else if (!order.getStatus().equals("待服务")){
            throw new Exception("订单异常");
        }
        //进入待确认
        order.setStatus(OrderExtend.STATUS_DQR);
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void confirmOrder(long orderId) throws Exception {
        //用户确认
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order==null){
            throw new Exception("该订单不存在");
        }else if (!order.getStatus().equals("待确认")){
            throw new Exception("订单异常");
        }
        //已完成
        order.setStatus(OrderExtend.STATUS_YWC);
        orderMapper.updateByPrimaryKey(order);
    }
}
