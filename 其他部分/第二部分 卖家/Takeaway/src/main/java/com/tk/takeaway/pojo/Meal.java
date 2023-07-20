package com.tk.takeaway.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("`meal`")
public class Meal {
    @TableField("id")
    Integer id;
    @TableField("sellerid")
    Integer sellerid;
    @TableField("message")
    String message;
    @TableField("support")
    String support;
    @TableField("name")
    String name;
    @TableField("price")
    double price;
    @TableField("kind")
    String kind;
    @TableField("money")
    double money;
    @TableField("picture")
    String picture;

}
