package com.tk.takeaway.service;

import com.tk.takeaway.pojo.Meal;

import java.util.List;

public interface MealService {
    List<Meal> getMealList(String kind);
    Meal getMealById(Integer id);
    List<Meal> getMealByName(String kind,String name);
}
