package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.AccountCustomer;
import com.edu.zzuli.service.AccountCustomerService;
import com.edu.zzuli.utils.Message;
import com.edu.zzuli.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AccountCustomerController
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 21:07
 */
@RestController
@RequestMapping("/accountcustomer")
@Api(description = "用户账户管理接口")
public class AccountCustomerController {
    @Resource
    private AccountCustomerService accountCustomerService;

    @GetMapping("getAll")
    public Message getAll(){
        List<AccountCustomer> list = accountCustomerService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation("通过ID删除信息")
    @GetMapping("/deleteById")
    public Message deleteById(long id){
        accountCustomerService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody AccountCustomer accountCustomer){
        accountCustomerService.saveOrUpdate(accountCustomer);
        return MessageUtil.success("保存成功");
    }
}
