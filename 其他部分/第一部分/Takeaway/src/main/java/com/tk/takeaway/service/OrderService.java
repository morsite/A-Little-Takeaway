package com.tk.takeaway.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.tk.takeaway.pojo.OrdAndMeal;
import com.tk.takeaway.pojo.Order;

import java.util.List;

public interface OrderService {

    List<Order> selectAllOrd();

    List<Order> selectOrdById(Integer id);
//查状态
    int selectState(Integer id);
//    更改订单状态为
    boolean updateState(Integer id,String state ,Integer tostate);

//    查询OAM里面的数据
    List<OrdAndMeal> selectOAM();

//


}
