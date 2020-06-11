package com.edu.zzuli.dao.extend;

import com.edu.zzuli.entity.Category;
import com.edu.zzuli.entity.extend.CategoryExtend;

import java.util.List;

/**
 * @Classname CategoryExtendMapper
 * @Description TODO
 * @Date 2020/6/11 19:59
 * @Created by cccp
 */
public interface CategoryExtendMapper {
    List<CategoryExtend> selectAllWithChild();
    Category selectByParentId(long id);
}
