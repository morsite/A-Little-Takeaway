package com.tk.takeaway.service;

import com.tk.takeaway.pojo.Meal;

import java.util.List;

public interface MealService {
    List<Meal> selectAllMealByMy();

    boolean addMeal(Meal meal);

    boolean deleteById(Integer id);
}
