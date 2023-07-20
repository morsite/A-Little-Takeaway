package com.tk.takeaway.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rider implements Serializable {

    private static final long serialVersionUID = -667032272847084983L;
//    @TableId  将private Integer riderid; 设为表中id 主键
    @TableId
    private Integer riderid;
    String ridername;
    String ridertelephone;
    Integer commission;
    String state;
    String password;
}
