package com.tk.takeaway.controller;

import com.tk.takeaway.common.R;
import com.tk.takeaway.pojo.Seller;
import com.tk.takeaway.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/login")
    public R login(String sname, String spwd){
        List<Seller> sellers = sellerService.selectSellerByIdAndPwd(sname, spwd);
        if (sellers != null) {
            return R.ok("登录成功",sellers);
        } else {
            return R.fail("用户名或者密码不正确");
        }
    }

    @PostMapping("/regiest")
    public R regiest(Seller seller){
        seller.setId(0);
        System.out.println(seller);
        boolean b = sellerService.insertSeller(seller);
        if (b==true){

            return R.ok("成功",b);
        } else {
            return R.fail("失败");
        }
    }
}
