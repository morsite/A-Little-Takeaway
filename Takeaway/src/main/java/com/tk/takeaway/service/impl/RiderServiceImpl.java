package com.tk.takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.takeaway.mapper.RiderMapper;
import com.tk.takeaway.pojo.Order;
import com.tk.takeaway.pojo.Rider;
import com.tk.takeaway.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderServiceImpl extends ServiceImpl<RiderMapper, Rider> implements RiderService {

    @Override
    public List<Rider> selectRidByIdAndPwd(String rid, String pwd) {
        QueryWrapper<Rider> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("riderid",rid);
        objectQueryWrapper.eq("password",pwd);
        List<Rider> riders = baseMapper.selectList(objectQueryWrapper);
        return riders;
    }

    @Override
    public boolean register(Rider rider) {

        Rider rider1 = baseMapper.selectById(rider.getRiderid());
//        System.out.println("111");
        if(rider1 == null){
            return baseMapper.insert(rider)>0?true:false;
        }else {
            return false;
        }

    }


}
