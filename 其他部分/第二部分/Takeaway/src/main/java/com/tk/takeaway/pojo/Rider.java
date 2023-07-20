package com.tk.takeaway.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rider {
    Integer id;
    String name;
    String telephone;
    Integer commission;
    String state;
}
