package com.tk.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tk.takeaway.pojo.Meal;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MealMapper extends BaseMapper<Meal> {
    @Select("select * from meal where kind=#{kind}")
    public List<Meal> selectOneByKindMeals(String kind);
}
