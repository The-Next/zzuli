package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.OrderLine;
import com.edu.zzuli.service.OrderService;
import com.edu.zzuli.utils.Message;
import com.edu.zzuli.utils.MessageUtil;
import com.edu.zzuli.vm.OrderVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName OrderController
 * @Description todo
 * @Author CY
 * @Date 2020/06/12 20:01
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("commit")
    @ApiOperation("提交订单")
    public Message commit(@RequestBody OrderVM orderVM){
        orderService.commit(orderVM);
        return MessageUtil.success("提交成功");
    }
    @GetMapping("findAll")
    public Message findAll(){
        return MessageUtil.success("success",orderService.findAll());
    }

    @GetMapping("findById")
    public Message findById(long id){
        return MessageUtil.success("success",orderService.findOrderDetailsById(id));
    }

}
