package com.tk.takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tk.takeaway.mapper.BuyerMapper;
import com.tk.takeaway.pojo.Buyer;
import com.tk.takeaway.service.BuyerService;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl extends ServiceImpl<BuyerMapper, Buyer> implements BuyerService {
    /*买家登录*/
    @Override
    public boolean login(Integer id, String pwd) {
        Buyer buyer = baseMapper.selectById(id);
        if(buyer == null){
            return false;
        }else {
            if(buyer.getPassword().equals(pwd)){
                return true;
            }else{
                return false;
            }
        }
    }
    @Override
    public int insert(Buyer buyer) {
        Buyer buy = baseMapper.getBuyerByIdAndPwd(buyer.getId(), buyer.getPassword());
        int insert = baseMapper.insert(buyer);
        Boolean in = insert>0;
        if(buy==null){
            if(in){
                return 0;//正常，注册成功
            }
            return 1;//注册失败
        }else{
            return 2;//账号id重复
        }
    }

    @Override
    public boolean delete(Buyer buyer) {
        return false;
    }

    @Override
    public boolean update(Buyer buyer) {
        return false;
    }

}
