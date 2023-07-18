package com.tk.takeaway.service;

import com.tk.takeaway.pojo.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;

public interface OrderService {
    int order( Integer id,  String desc,
               String tel,  String address,Integer bid, long ordertime);
}
