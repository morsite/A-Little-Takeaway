package com.tk.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tk.takeaway.pojo.Buyer;
import org.apache.ibatis.annotations.Select;

public interface BuyerMapper extends BaseMapper<Buyer> {
    @Select("select * from buyer where id = #{id} and password = #{password}")
    public Buyer getBuyerByIdAndPwd(Integer id, String password);
}
