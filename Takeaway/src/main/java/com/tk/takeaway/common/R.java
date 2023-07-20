package com.tk.takeaway.common;

import lombok.Data;

/**
 * 统一数据响应格式
 */
@Data
public class R {
//    成功状态码
    public static final String SUCCESS_CODE = "001";
//    失败的状态码
    public static final String FAIL_CODE = "002";

//    提示信息
    private String msg;

//    携带数据
    private Object data;

//    状态码
    private String code;

    public R(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

//    操作成功 通过ok方法返回R数据
    public static com.tk.takeaway.common.R ok(String msg, Object data){
        return new com.tk.takeaway.common.R(SUCCESS_CODE,msg,data);
    }

    public static com.tk.takeaway.common.R ok(String msg){
        return new com.tk.takeaway.common.R(SUCCESS_CODE,msg,null);
    }


//    操作失败 通过fail方法返回R数据
    public static com.tk.takeaway.common.R fail(String msg, Object data){
        return new com.tk.takeaway.common.R(FAIL_CODE,msg,data);
    }

    public static com.tk.takeaway.common.R fail(String msg){
        return new com.tk.takeaway.common.R(FAIL_CODE,msg,null);
    }






}
