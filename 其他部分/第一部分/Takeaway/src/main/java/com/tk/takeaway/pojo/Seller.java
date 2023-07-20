package com.tk.takeaway.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    Integer id;
    String name;
    String telephone;
    String address;
    String password;
}
