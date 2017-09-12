package com.example.entity;

/**
 * Created by GuYang on 2017/9/12.
 */
public class MyExcepetion extends RuntimeException {
    private Integer code;
    public MyExcepetion(ResultCode resultCode){
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
