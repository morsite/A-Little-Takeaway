package com.tk.takeaway.service;

import com.tk.takeaway.pojo.Seller;

import java.util.List;

public interface SellerService {
    List<Seller> selectSellerByIdAndPwd(String sname,String spwd);

    boolean insertSeller(Seller seller);

    Seller getSeller(Integer id);

}
