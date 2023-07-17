package com.tk.takeaway.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tk.takeaway.pojo.Buyer;
import com.tk.takeaway.service.BuyerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@Api(tags = "buyer")
@RestController
@RequestMapping("/buyer")
public class BuyerController {
    @Resource
    BuyerService buyerService;
    @ApiOperation("买家登录")
    @PostMapping("/login")
    public JSON login(@RequestBody Buyer buyer){
        JSONObject obj = JSONUtil.createObj();
        boolean regist = buyerService.login(buyer.getId(), buyer.getPassword());
        if (regist){
            StpUtil.login(0);
            obj.set("code", "200");
            obj.set("msg", "登录成功");
        } else {
            obj.set("code", "400");
            obj.set("msg", "登录失败在后端");
        }
        return obj;
    }
    @ApiOperation("买家注册")
    @PostMapping("/regist")
    public JSON regist(@RequestBody Buyer buyer){
        JSONObject obj = JSONUtil.createObj();
        int insert = buyerService.insert(buyer);
        if (insert==0){
            obj.set("code", "200");
            obj.set("msg", "注册成功");
        } else if (insert==1){
            obj.set("code", "201");
            obj.set("msg", "注册失败");
        } else{
            obj.set("code", "202");
            obj.set("msg", "账号重复");
        }
        return obj;
    }
}
