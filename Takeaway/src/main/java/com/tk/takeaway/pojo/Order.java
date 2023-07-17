package com.tk.takeaway.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    Integer id;
    String message;
    String buyerTelephone;
    String sellerTelephone;
    String buyerAddress;
    String sellerAddress;
    String state;
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
}
