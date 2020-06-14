package com.edu.zzuli.service;

import com.edu.zzuli.entity.Category;
import com.edu.zzuli.entity.Comment;
import com.edu.zzuli.entity.extend.CommentExtend;

import java.util.List;

/**
 * @ClassName CommentService
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 18:18
 */
public interface CommentService {
    List<Comment> findAll();
    void deleteById(long id);
    void saveOrUpdate(Comment comment);
    List<CommentExtend> findAllWithChild();

}
