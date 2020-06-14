package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.Comment;
import com.edu.zzuli.entity.extend.CategoryExtend;
import com.edu.zzuli.entity.extend.CommentExtend;
import com.edu.zzuli.service.CommentService;
import com.edu.zzuli.utils.Message;
import com.edu.zzuli.utils.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Member;
import java.util.List;

/**
 * @ClassName CommentController
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 18:29
 */

@RestController
@RequestMapping("/comment")
@Api(description = "评论管理接口")
public class CommentController {
    @Resource
    private CommentService commentService;

    @GetMapping("getAll")
    public Message getAll(){
        List<Comment> list = commentService.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("/deleteById/{id}")
    public Message deleteById(long id){
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Comment comment){
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("保存成功");
    }

    @GetMapping("/findAllWithChild")
    public Message findAllWithChild(){
        List<CommentExtend> list = commentService.findAllWithChild();
        return MessageUtil.success(list);
    }
}
