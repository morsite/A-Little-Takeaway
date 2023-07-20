package com.tk.takeaway.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
    Integer id ;
    Integer sellerid;
    String message;
    String support;
    String name;
    Double price;
    String kind;
    double money;
    Image picture;
}
