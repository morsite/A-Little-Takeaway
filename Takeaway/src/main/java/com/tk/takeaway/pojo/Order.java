package com.tk.takeaway.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("`order`")
public class Order {
    Integer id;
    String message;
    @TableField("buyerTelephone")
    String buyerTelephone;
    @TableField("sellerTelephone")
    String sellerTelephone;
    @TableField("buyerAddress")
    String buyerAddress;
    @TableField("sellerAddress")
    String sellerAddress;
    String state;
    @TableField("orderTime")
    Timestamp orderTime;
    String  notes;
    Integer mealid;
public Order(Integer id, String message, Buyer buyer,Seller seller,String state,Timestamp orderTime ,String notes,Integer mealid){
    this.id = id;
    this.message = message;
    this.buyerTelephone = buyer.getTelephone();
    this.sellerTelephone = seller.getTelephone();
    this.buyerAddress = buyer.getAddress();
    this.sellerAddress = seller.getAddress();
    this.state = state;
    this.orderTime = orderTime;
    this.notes=notes;
    this.mealid=mealid;
}

    public Order(Integer id, String desc, String tel, String address, Seller seller, String number, long ordertime) {
        this.id = id;
        this.message = desc;
        this.buyerTelephone = tel;
        this.sellerTelephone = seller.getTelephone();
        this.buyerAddress = address;
        this.sellerAddress = seller.getAddress();
        this.state = number;
        this.orderTime = new Timestamp(ordertime);
    }
}
