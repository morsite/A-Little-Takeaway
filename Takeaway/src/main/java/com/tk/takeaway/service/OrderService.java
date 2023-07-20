package com.tk.takeaway.service;

import com.tk.takeaway.pojo.OrdAndMeal;
import com.tk.takeaway.pojo.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface OrderService {
    int order( Integer id,  String desc,
               String tel,  String address,Integer bid, long ordertime);

    List<Order> selectAllOrd();

    List<Order> selectOrdById(Integer id);
    //查状态
    int selectState(Integer id);
    //    更改订单状态为
    boolean updateState(Integer id,String state ,Integer tostate);

    //    查询OAM里面的数据
    List<OrdAndMeal> selectOAM();
    List<Order> selectAllOrdByMy();

//
}
