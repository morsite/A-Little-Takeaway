package com.tk.takeaway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.takeaway.mapper.SellerMapper;
import com.tk.takeaway.pojo.Seller;
import com.tk.takeaway.service.SellerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl extends ServiceImpl<SellerMapper, Seller> implements SellerService{
    @Override
    public List<Seller> selectSellerByIdAndPwd(String sname,String spwd) {
        QueryWrapper<Seller> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("name",sname);
        objectQueryWrapper.eq("password",spwd);
        List<Seller> sellers = baseMapper.selectList(objectQueryWrapper);
        return sellers;
    }

    @Override
    public boolean insertSeller(Seller seller) {

        int insert = baseMapper.insert(seller);
        if (insert>0){
            return true;
        }else {
            return false;
        }
    }

    public Seller getSeller(Integer id) {
        return baseMapper.selectById(id);
    }
}
