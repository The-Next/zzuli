package com.edu.zzuli.vm;

import com.edu.zzuli.entity.Order;
import com.edu.zzuli.entity.OrderLine;

import java.util.List;

/**
 * @ClassName OrderVM
 * @Description todo
 * @Author CY
 * @Date 2020/06/13 9:22
 */
public class OrderVM extends Order {
    private List<OrderLine> orderLines;

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
