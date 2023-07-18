package com.tk.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.takeaway.mapper.MealMapper;
import com.tk.takeaway.pojo.Meal;
import com.tk.takeaway.service.MealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MealServiceImpl extends ServiceImpl<MealMapper, Meal> implements MealService {

    @Override
    public List<Meal> getMealList(String kind) {
        String kinds="";
        switch (kind) {
            case "1":kinds = "mf";break;
            case "2":kinds = "mt";break;
            case "3":kinds = "hg";break;
            case "4":kinds = "kc";break;
            case "5":kinds = "xc";break;
            case "6":kinds = "bd";break;
            case "7":kinds = "cy";break;
            case "8":kinds = "xg";break;
        }
        return baseMapper.selectOneByKindMeals(kinds);
    }

    @Override
    public Meal getMealById(Integer id) {
        return baseMapper.selectById(id);
    }
}
