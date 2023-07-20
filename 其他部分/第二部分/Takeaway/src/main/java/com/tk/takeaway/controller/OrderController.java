package com.tk.takeaway.controller;

import com.tk.takeaway.common.R;
import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/selectAllOrdByMy")
    public R selectAllOrdByMy(){
        List<Order> orders = orderService.selectAllOrdByMy();
        if (orders!=null){
            return R.ok("查询成功",orders);
        }else {
            return R.fail("没查询成功");
        }
    }
}
