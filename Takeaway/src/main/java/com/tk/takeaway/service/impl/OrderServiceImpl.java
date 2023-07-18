package com.tk.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.takeaway.mapper.OrderMapper;
import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.pojo.Seller;
import com.tk.takeaway.service.OrderService;
import com.tk.takeaway.service.SellerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Resource
    SellerService service;
    @Override
    public int order(Integer id, String desc,
                     String tel, String address, Integer bid, long ordertime) {
        Seller seller = service.getSeller(bid);
        System.out.println(seller);
        Order order = new Order(id, desc, tel, address, seller, "1", ordertime);
        return baseMapper.insert(order);
    }
}
