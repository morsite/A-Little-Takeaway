package com.tk.takeaway.service;

import com.tk.takeaway.pojo.Buyer;

public interface BuyerService {
boolean login(Integer id,String pwd);
int insert(Buyer buyer);
boolean delete(Buyer buyer);
boolean update(Buyer buyer);


}
