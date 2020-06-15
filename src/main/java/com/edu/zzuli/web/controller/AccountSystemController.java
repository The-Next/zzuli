package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.AccountSystem;
import com.edu.zzuli.service.AccountSystemService;
import com.edu.zzuli.utils.Message;
import com.edu.zzuli.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName AccountSystemController
 * @Description todo
 * @Author CY
 * @Date 2020/06/14 21:45
 */
@RestController
@RequestMapping("accountsystem")
@Api(description = "管理员账户管理接口")
public class AccountSystemController {
    @Resource
    private AccountSystemService accountSystemService;

    @GetMapping("getAll")
    public Message getAll(){
        List<AccountSystem> list = accountSystemService.findAll();
        return MessageUtil.success(list);
    }
    @ApiOperation("通过ID删除信息")
    @GetMapping("/deleteById")
    public Message deleteById(long id){
        accountSystemService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody AccountSystem accountSystem){
        accountSystemService.saveOrUpdate(accountSystem);
        return MessageUtil.success("保存成功");
    }
}
