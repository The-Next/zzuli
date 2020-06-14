package com.edu.zzuli.service.impl;

import com.edu.zzuli.dao.CommentMapper;
import com.edu.zzuli.dao.extend.CommentExtendMapper;
import com.edu.zzuli.entity.Comment;
import com.edu.zzuli.entity.extend.CommentExtend;
import com.edu.zzuli.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CommentService
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 18:18
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private CommentExtendMapper commentExtendMapper;

    @Override
    public List<Comment> findAll() {
        return commentMapper.selectByExample(null);
    }

    @Override
    public void deleteById(long id) {
        commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Comment comment) {
        if (comment.getId()!=null){
            commentMapper.updateByPrimaryKey(comment);
        }else {
            commentMapper.insert(comment);
        }
    }

    @Override
    public List<CommentExtend> findAllWithChild() {
        return commentExtendMapper.selectAllWithChild();
    }
}
