package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.AccountEmployee;
import com.edu.zzuli.service.AccountEmployeeService;
import com.edu.zzuli.utils.Message;
import com.edu.zzuli.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AccountEmployeeController
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 21:30
 */
@RestController
@RequestMapping("/accountemployee")
@Api(description = "员工账户管理接口")
public class AccountEmployeeController {
    @Resource
    private AccountEmployeeService accountEmployeeService;

    @GetMapping("getAll")
    public Message getAll() {
        List<AccountEmployee> list = accountEmployeeService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation("通过ID删除信息")
    @GetMapping("/deleteById")
    public Message deleteById(long id) {
        accountEmployeeService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody AccountEmployee accountCustomer) {
        accountEmployeeService.saveOrUpdate(accountCustomer);
        return MessageUtil.success("保存成功");
    }
}
