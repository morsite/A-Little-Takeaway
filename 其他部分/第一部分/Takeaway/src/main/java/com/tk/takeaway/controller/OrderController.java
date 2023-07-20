package com.tk.takeaway.controller;

import com.tk.takeaway.pojo.OrdAndMeal;
import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.service.OrderService;
import com.tk.takeaway.service.RiderService;
import common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/selectAllOrd")
    public R selectAllOrd(){
        List<Order> list = orderService.selectAllOrd();
        if(list != null && list.size()>0){
            return R.ok("查询所有用户成功",list);
        }else {
            return R.fail("失败");
        }
    }
    /**
     * 将派送中状态3 变为已送达 4
     * @param id
     * @return
     */
    @GetMapping("/updateStateTo4/{id}")
    public R updateStateTo4(@PathVariable("id") Integer id){
        int state = orderService.selectState(id);
        boolean b=false;
        if(state==3){
//            更改订单状态
            b = orderService.updateState(id, String.valueOf(state), 4);
        }
        if(b){
            return R.ok("已送达",b);
        }else {
            return R.fail("送达失败",b);
        }
    }
    /**
     * 查 顺便根据状态判断是否还能再次接单 成功结束后该状态为3
     * @param id
     * @return
     */
    @GetMapping("/selectOrdById/{id}")
    public R selectOrdById(@PathVariable("id") Integer id){
        System.out.println(id);
        int state = orderService.selectState(id);
        //如果订单状态是2 则可以接单
        if(state == 2){
//            更改订单状态
            boolean b = orderService.updateState(id, String.valueOf(state),3);
            System.out.println("修改订单"+b);
            List<Order> list = orderService.selectOrdById(id);
            if(list !=null && list.size()>0){
                return R.ok("接单成功",list);
            }else {
                return R.fail("失败");
            }
        }else if(state ==3){
            return R.fail("不可重复接单,该订单号为"+id);
        }else if(state ==0){
            return  R.fail(id+"号订单尚在在购物车,无法接单");
        }else if(state==1){
            return R.fail(id+"号订单商家尚未出餐,请等待");
        }else if(state == 4){
            return R.fail(id+"号订单已送达");
        }else
            return R.fail("出错啦,请联系客服");
    }
    /**
     * 查询OAM数据
     * @return
     */
    @GetMapping("/selectOAM")
    public R selectOAM(){
        List<OrdAndMeal> list = orderService.selectOAM();

        if(list != null && list.size()>0){
            return R.ok("查询所有用户成功",list);
        }else {
            return R.fail("失败");
        }
    }
//    查询佣金总额
    @GetMapping("/selectSum")
    public R selectSum(){
//        orderService.selectSum
        List<Order> orders = orderService.selectAllOrd();
//       定义sum
        double sum=0;
//        循环查询所有订单
        for (Order o : orders){
            Integer id = o.getId();
//            根据id查询订单状态
            int state = orderService.selectState(id);
            if(state==4){
                List<OrdAndMeal> OrdAndMeal = orderService.selectOAM();
//                循环查询其佣金
                for (OrdAndMeal oam:OrdAndMeal){
                    double money = oam.getMoney();
                    sum+=money;
                }
            }
        }
        if(sum>=0){
            return R.ok("查询总金额成功",sum);
        }else {
            return R.fail("查询总金额失败");
        }
    }
    @GetMapping("/selectOrdByState")
    public R selectOrdByState(){
        List<Order> orders = orderService.selectAllOrd();
        ArrayList<Order> orders2=new ArrayList<>();
        for (Order o : orders){
            int state = orderService.selectState(o.getId());
            if(state==3){
                orders2.add(o);
                System.out.println(orders2);
            }
        }
        System.out.println(orders2);
        if(orders2!=null&&orders2.size()>0){
            return R.ok("已查询到已接单数据",orders2);
        }else {
            return R.fail("发生了什么");
        }
    }

}
