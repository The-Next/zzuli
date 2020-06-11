package com.edu.zzuli.dao.extend;

import com.edu.zzuli.entity.extend.ProductExtend;

import java.util.List;

/**
 * @Classname ProductExtendMapper
 * @Description TODO
 * @Date 2020/6/11 20:00
 * @Created by cccp
 */
public interface ProductExtendMapper {
    List<ProductExtend> selectAllWithCategory();
}
