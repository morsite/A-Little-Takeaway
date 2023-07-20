package com.tk.takeaway.service;

import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.pojo.Rider;

import java.util.List;

public interface RiderService {

    List<Rider> selectRidByIdAndPwd(String rid, String pwd);

    boolean register(Rider rider);

}
