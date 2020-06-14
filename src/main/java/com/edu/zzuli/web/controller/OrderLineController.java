package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.OrderLine;
import com.edu.zzuli.service.OrderLineService;
import com.edu.zzuli.utils.Message;
import com.edu.zzuli.utils.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname OrderLineController
 * @Description TODO
 * @Date 2020/6/14 17:50
 * @Created by cccp
 */
@RestController
@RequestMapping("orderline")
public class OrderLineController {
    @Resource
    private OrderLineService orderLineService;
    @GetMapping("/getOrderLineByOrder/{id}")
    private Message getOrderLineByOrder(@PathVariable("id") long id){
        List<OrderLine> lines = orderLineService.findByOrderId(id);
        return MessageUtil.success(lines);
    }
    @GetMapping("/getOrderLineByProduct/{id}")
    private Message getOrderLineByProduct(@PathVariable("id") long id){
        List<OrderLine> lines = orderLineService.findByProductId(id);
        return MessageUtil.success(lines);
    }
}
