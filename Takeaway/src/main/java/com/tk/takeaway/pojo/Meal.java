package com.tk.takeaway.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    Integer id;
    Integer sellerid;
    String message;
    String support;
    String name;
    Double price;
    String kind;
    String money;
    String picture;
}
