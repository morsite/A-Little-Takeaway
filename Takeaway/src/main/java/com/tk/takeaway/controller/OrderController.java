package com.tk.takeaway.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tk.takeaway.pojo.Meal;
import com.tk.takeaway.pojo.OrdAndMeal;
import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.service.MealService;
import com.tk.takeaway.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.tk.takeaway.common.R;

@Api(tags = "order")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;
    @ApiOperation("新订单")
    @GetMapping("/neworder")
    public JSON add(@RequestParam Integer id, @RequestParam String desc, @RequestParam String num,
                    @RequestParam String tel, @RequestParam String address, @RequestParam String name
                   /* @RequestParam @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd HH-mm-ss") Timestamp orderTime*/, @RequestParam Integer bid){
        JSONObject obj = JSONUtil.createObj();
        if(StpUtil.isLogin()){
            String message = name+","+num+","+desc;
            long time = new Date().getTime();
            int i = orderService.order(id, message,tel,address,bid,time);
            if(i == 0){
                obj.set("code","201");
                obj.set("msg","失败");
            }else{
                obj.set("code","200");
                obj.set("msg","成功");
            }
        }else{
            obj.set("code","500");
            obj.set("msg","未登录");
        }
        return obj;
    }

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
