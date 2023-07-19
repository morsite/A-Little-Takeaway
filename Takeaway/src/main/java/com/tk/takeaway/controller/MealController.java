package com.tk.takeaway.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tk.takeaway.pojo.Meal;
import com.tk.takeaway.service.MealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "meals")
@RestController
@RequestMapping("/meal")
public class MealController {
    @Resource
    MealService mealService;
    @ApiOperation("饭菜列表")
    @GetMapping("/kindmeal")
    public JSON selectOneKindMeal(@RequestParam String kind){
        JSONObject obj = JSONUtil.createObj();
        if(StpUtil.isLogin()){
        List<Meal> mealList = mealService.getMealList(kind);
        if(mealList.size() == 0){
            obj.set("code","201");
            obj.set("msg","查询失败");
        }else{
            obj.set("code","200");
            obj.set("all",mealList);
            obj.set("msg","查询成功");
        }
        }else{
            obj.set("code","500");
            obj.set("msg","未登录");
        }
        return obj;
    }
    @ApiOperation("某一道菜")
    @GetMapping("/onemeal")
    public JSON select(@RequestParam Integer id){
        JSONObject obj = JSONUtil.createObj();
        if(StpUtil.isLogin()){
            Meal mealById = mealService.getMealById(id);
            if(mealById==null){
                obj.set("code","201");
                obj.set("msg","查询失败");
            }else{
                obj.set("code","200");
                obj.set("all",mealById);
                obj.set("msg","查询成功");
            }
        }else{
            obj.set("code","500");
            obj.set("msg","未登录");
        }
        return obj;
    }

    @ApiOperation("根据名称查饭菜列表")
    @GetMapping("/namemeal")
    public JSON selectOneKindMealAndName(@RequestParam String kind,@RequestParam String name){
        JSONObject obj = JSONUtil.createObj();
        if(StpUtil.isLogin()){
            List<Meal> mealList = mealService.getMealByName(kind,name);
            if(mealList.size() == 0){
                obj.set("code","201");
                obj.set("msg","查询失败");
            }else{
                obj.set("code","200");
                obj.set("all",mealList);
                obj.set("msg","查询成功");
            }
        }else{
            obj.set("code","500");
            obj.set("msg","未登录");
        }
        return obj;
    }
}
