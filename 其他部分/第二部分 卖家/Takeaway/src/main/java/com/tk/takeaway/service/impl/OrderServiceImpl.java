package com.tk.takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.takeaway.mapper.OrderMapper;
import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.pojo.Seller;
import com.tk.takeaway.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public List<Order> selectAllOrdByMy() {
        List<Order> orders = baseMapper.selectList(null);
        return orders;
    }

}
