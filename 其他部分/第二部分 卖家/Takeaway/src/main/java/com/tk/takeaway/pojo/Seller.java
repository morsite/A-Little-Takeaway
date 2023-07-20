package com.tk.takeaway.pojo;

import com.tk.takeaway.service.SellerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller implements Serializable {

    private static final long serialVersionUID = 6179451472094680460L;

    Integer id;
    String name;
    String telephone;
    String address;
    String password;
}
