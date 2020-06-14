package com.edu.zzuli.entity.extend;

import com.edu.zzuli.entity.Category;
import com.edu.zzuli.entity.Comment;

import java.util.List;

/**
 * @ClassName CommentExtend
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 18:28
 */
public class CommentExtend extends Comment {
    private List<Comment> children;
    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
    }

}
