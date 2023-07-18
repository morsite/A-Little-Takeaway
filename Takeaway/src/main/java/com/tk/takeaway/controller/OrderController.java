package com.tk.takeaway.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tk.takeaway.pojo.Meal;
import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.service.MealService;
import com.tk.takeaway.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Api(tags = "order")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;
    @ApiOperation("新订单")
    @GetMapping("/neworder")
    public JSON add(@RequestParam Integer id, @RequestParam String desc, @RequestParam String num,
                    @RequestParam String tel, @RequestParam String address, @RequestParam String name
                   /* @RequestParam @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd HH-mm-ss") Timestamp orderTime*/, @RequestParam Integer bid){
        JSONObject obj = JSONUtil.createObj();
        if(StpUtil.isLogin()){
            String message = name+","+num+","+desc;
            long time = new Date().getTime();
            int i = orderService.order(id, message,tel,address,bid,time);
            if(i == 0){
                obj.set("code","201");
                obj.set("msg","失败");
            }else{
                obj.set("code","200");
                obj.set("msg","成功");
            }
        }else{
            obj.set("code","500");
            obj.set("msg","未登录");
        }
        return obj;
    }
}
