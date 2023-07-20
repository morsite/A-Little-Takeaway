package com.tk.takeaway.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCar {
    Integer id;
    Integer orderId;
    String orderMessage;
    Timestamp orderTime;
    String buyerId;
}
