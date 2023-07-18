package com.tk.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.takeaway.mapper.SellerMapper;
import com.tk.takeaway.pojo.Seller;
import com.tk.takeaway.service.SellerService;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl extends ServiceImpl<SellerMapper, Seller> implements SellerService{
    @Override
    public Seller getSeller(Integer id) {
        return baseMapper.selectById(id);
    }
}
