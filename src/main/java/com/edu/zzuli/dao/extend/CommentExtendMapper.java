package com.edu.zzuli.dao.extend;

import com.edu.zzuli.entity.Comment;
import com.edu.zzuli.entity.extend.CommentExtend;

import java.util.List;

/**
 * @ClassName CommentExtendMapper
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 18:28
 */
public interface CommentExtendMapper {
    List<CommentExtend> selectAllWithChild();
    Comment selectByParentId(long id);
}
