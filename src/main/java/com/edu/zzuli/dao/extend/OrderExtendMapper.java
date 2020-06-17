package com.edu.zzuli.dao.extend;

import com.edu.zzuli.entity.extend.OrderExtend;

import java.util.List;

/**
 * @ClassName OrderExtendMapper
 * @Description todo
 * @Author CY
 * @Date 2020/06/13 9:57
 */
public interface OrderExtendMapper {
    List<OrderExtend> query(Long id, String status);
}
