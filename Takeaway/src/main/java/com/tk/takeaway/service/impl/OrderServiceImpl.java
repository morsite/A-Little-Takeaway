package com.tk.takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.takeaway.mapper.MealMapper;
import com.tk.takeaway.mapper.OrderMapper;
import com.tk.takeaway.pojo.Meal;
import com.tk.takeaway.pojo.OrdAndMeal;
import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.pojo.Seller;
import com.tk.takeaway.service.OrderService;
import com.tk.takeaway.service.SellerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Resource
    MealMapper mealMapper;
    //    查询订单列表
    @Override
    public List<Order> selectAllOrd() {
        List<Order> orders = baseMapper.selectList(null);
        return orders;
    }

    /**
     *按id查询
     * @param id
     * @return
     */
    @Override
    public List<Order> selectOrdById(Integer id) {
        QueryWrapper<Order> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("id",id);
        List<Order> orders = baseMapper.selectList(objectQueryWrapper);

        return orders;
    }
    /**
     * 判断订单状态
     * @param id
     * @return
     */
    @Override
    public int selectState(Integer id) {
        QueryWrapper<Order> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("id",id);
        List<Order> orders = baseMapper.selectList(objectQueryWrapper);
        int state = Integer.parseInt( orders.get(0).getState());
        return state;
    }
    /**
     *修改订单状态为3
     * @param id
     * @param state
     * @param tostate
     * @return
     */
    @Override
    public boolean updateState(Integer id,String state,Integer tostate) {
        QueryWrapper<Order> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("id",id);
        List<Order> orders = baseMapper.selectList(objectQueryWrapper);
        Order order = orders.get(0);
        order.setState(String.valueOf(tostate));
        baseMapper.updateById(order);
        return true;
    }
//
//查双表数据


    @Override
    public List<OrdAndMeal> selectOAM() {
        ArrayList<OrdAndMeal> ordAndMeals = new ArrayList<>();
        List<Order> orders = baseMapper.selectList(null);
        for (Order o : orders){
            //根据相关id查到数据
            Meal meal = mealMapper.selectById(o.getMealid());
            System.out.println("meal"+meal);
            //添加数据
            OrdAndMeal ordAndMeal = new OrdAndMeal(o.getId(), meal.getMoney());
            ordAndMeals.add(ordAndMeal);
        }
        return ordAndMeals;
    }

    @Override
    public List<Order> selectAllOrdByMy() {
        List<Order> orders = baseMapper.selectList(null);
        return orders;
    }
}
