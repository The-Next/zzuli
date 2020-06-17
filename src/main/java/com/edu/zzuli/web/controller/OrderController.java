package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.OrderLine;
import com.edu.zzuli.service.OrderService;
import com.edu.zzuli.utils.Message;
import com.edu.zzuli.utils.MessageUtil;
import com.edu.zzuli.vm.OrderVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
@Api(description = "订单管理接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("commit")
    @ApiOperation("提交订单")
    public Message commit(@RequestBody OrderVM orderVM){
        orderService.commit(orderVM);
        return MessageUtil.success("提交成功");
    }
    @GetMapping("query")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "订单状态",required = false,paramType = "query")
    })
    public Message query(String status){
        return MessageUtil.success("success",orderService.query(status));
    }
    @GetMapping("findAll")
    public Message findAll(){
        return MessageUtil.success("success",orderService.findAll());
    }

    @GetMapping("findById")
    public Message findById(long id){
        return MessageUtil.success("success",orderService.findOrderDetailsById(id));
    }

    @GetMapping("payOrder")
    @ApiOperation("支付订单")
    public Message payOrder(long orderId) throws Exception{
        orderService.payOrder(orderId);
        return MessageUtil.success("success");
    }

    @GetMapping("sendOrder")
    @ApiOperation("派单")
    public Message sendOrder(long orderId,long employeeId) throws Exception{
        orderService.sendOrder(orderId,employeeId);
        return MessageUtil.success("success");
    }


    @GetMapping("rejectOrder")
    @ApiOperation("服务订单")
    public Message rejectOrder(long orderId) throws Exception{
        orderService.rejectOrder(orderId);
        return MessageUtil.success("success");
    }

    @GetMapping("confirmOrder")
    @ApiOperation("确认订单")
    public Message confirmOrder(long orderId) throws Exception{
        orderService.confirmOrder(orderId);
        return MessageUtil.success("success");
    }
}
