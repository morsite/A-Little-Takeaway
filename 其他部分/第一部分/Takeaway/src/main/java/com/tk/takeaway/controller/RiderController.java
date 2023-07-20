package com.tk.takeaway.controller;


import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.pojo.Rider;
import com.tk.takeaway.service.RiderService;
import common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rider")
public class RiderController {

    @Autowired
    private RiderService riderService;

    @PostMapping("/login")
    public R login(String  rid,String pwd){
        List<Rider> riders = riderService.selectRidByIdAndPwd(rid, pwd);
        if(riders!=null){
            return R.ok("登录成功",riders);
        }else {
            return R.fail("id或密码错误");
        }
    }
    @PostMapping("/register")
    public R register(Rider rider){
//        rider.setCommission(0);
//        rider.setState("0");
        rider.setCommission(0);
        rider.setState("0");
        boolean flag = riderService.register(rider);
        if(flag){
            return R.ok("注册成功");
        }else {
            return R.fail("注册失败");
        }
    }


}
