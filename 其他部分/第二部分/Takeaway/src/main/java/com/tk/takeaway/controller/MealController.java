package com.tk.takeaway.controller;

import com.tk.takeaway.common.R;
import com.tk.takeaway.pojo.Meal;
import com.tk.takeaway.service.MealService;
import com.tk.takeaway.service.impl.MealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping("/selectAllMealByMy")
    public R selectAllMealByMy(){
        List<Meal> meals = mealService.selectAllMealByMy();
        if (meals!=null){
            return R.ok("查询成功",meals);
        }else {
            return R.fail("没查询成功");
        }
    }


    @PostMapping("/addMeal")
    public R addMeal(@RequestBody Meal meal){
        meal.setId(0);
        System.out.println(meal);
        boolean b = mealService.addMeal(meal);
        if (b==true){
            return R.ok("添加成功");
        }else {
            return R.fail("新增失败");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public R deleteById(@PathVariable Integer id){
        boolean b = mealService.deleteById(id);
        if (b==true){
            return R.ok("删除成功");
        }else {
            return R.fail("删除失败");
        }
    }

}
