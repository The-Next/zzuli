package com.edu.zzuli.dao.extend;

import com.edu.zzuli.entity.OrderLine;

import java.util.List;

/**
 * @ClassName OrderLineExtendMapper
 * @Description todo
 * @Author CY
 * @Date 2020/06/13 10:33
 */
public interface OrderLineExtendMapper {
    List<OrderLine> selectByOrderId(long id);
}
