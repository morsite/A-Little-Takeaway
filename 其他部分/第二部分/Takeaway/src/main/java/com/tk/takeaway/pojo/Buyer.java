package com.tk.takeaway.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
    Integer id;
    String name;
    String Telephone;
    String address;
}
