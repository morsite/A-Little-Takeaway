package com.tk.takeaway.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("`order`")
public class Order {
    Integer id;
    @TableField("message")
    String message;
    @TableField("buyerTelephone")
    String buyerTelephone;
    @TableField("sellerTelephone")
    String sellerTelephone;
    @TableField("buyerAddress")
    String buyerAddress;
    @TableField("sellerAddress")
    String sellerAddress;
    @TableField("state")
    String state;
    @TableField("orderTime")
    Timestamp orderTime;
public Order(Integer id, String message, Buyer buyer,Seller seller,String state,Timestamp orderTime){
    this.id = id;
    this.message = message;
    this.buyerTelephone = buyer.getTelephone();
    this.sellerTelephone = seller.getTelephone();
    this.buyerAddress = buyer.getAddress();
    this.sellerAddress = seller.getAddress();
    this.state = state;
    this.orderTime = orderTime;
}
public Order(Integer id, String message, String buyerTelephone, String buyerAddress, Seller seller, String state, long orderTime){
    this.id = id;
    this.message = message;
    this.buyerTelephone = buyerTelephone;
    this.sellerTelephone = seller.getTelephone();
    this.buyerAddress = buyerAddress;
    this.sellerAddress = seller.getAddress();
    this.state = state;
    this.orderTime = new Timestamp(orderTime);
}
}
