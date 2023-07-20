package com.tk.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.takeaway.mapper.MealMapper;
import com.tk.takeaway.mapper.OrderMapper;
import com.tk.takeaway.pojo.Meal;

import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.service.MealService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper,Meal> implements MealService {
    @Override
    public List<Meal> selectAllMealByMy() {
        List<Meal> meals = baseMapper.selectList(null);
        return meals;
    }

    @Override
    public boolean addMeal(Meal meal) {
        int insert = baseMapper.insert(meal);
        if (insert>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        int i = baseMapper.deleteById(id);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
}
