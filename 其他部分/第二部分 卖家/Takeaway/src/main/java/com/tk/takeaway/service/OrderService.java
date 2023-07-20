package com.tk.takeaway.service;

import com.tk.takeaway.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> selectAllOrdByMy();

}
