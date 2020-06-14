package com.edu.zzuli.web.controller;

import com.edu.zzuli.entity.Address;
import com.edu.zzuli.service.AddressService;
import com.edu.zzuli.utils.Message;
import com.edu.zzuli.utils.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname AddressController
 * @Description TODO
 * @Date 2020/6/14 17:07
 * @Created by cccp
 */
@RestController
@RequestMapping("/address")
@Api(description = "地址管理接口")
public class AddressController {
    @Resource
    private AddressService addressService;

    @PostMapping("/saveOrUpdate")
    public Message saveOrUpdate(@RequestBody Address address){
        addressService.saveOrUpdate(address);
        return MessageUtil.success("保存或更改成功");
    }

    @GetMapping("/deleteById/{id}")
    public Message deleteById(@PathVariable("id") long id){
        addressService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @GetMapping("/findAllWithUserId/{id}")
    public Message findAllWithUserId(@PathVariable("id") long id){
        List<Address> addresses = addressService.findAllWithUserId(id);
        return MessageUtil.success(addresses);
    }
}
