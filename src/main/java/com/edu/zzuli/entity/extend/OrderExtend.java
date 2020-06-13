package com.edu.zzuli.entity.extend;

import com.edu.zzuli.entity.Address;
import com.edu.zzuli.entity.Order;
import com.edu.zzuli.entity.OrderLine;
import com.edu.zzuli.entity.User;

import java.util.List;

/**
 * @ClassName OrderExtend
 * @Description todo
 * @Author CY
 * @Date 2020/06/13 9:32
 */
public class OrderExtend extends Order {
    public static final String STATUS_WFK="未付款";
    public static final String STATUS_WFH="未发货";
    public static final String STATUS_DSH="待收货";
    public static final String STATUS_DQR="待确认";
    public static final String STATUS_YWC="已完成";

    private User customer;
    private User employee;
    private Address address;
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
