package com.example.entity;

/**
 * Created by GuYang on 2017/9/12.
 */
public enum ResultCode {
    UNKNOW_ERROR(-1,"未知错误"),

    SUCCESS(0,"成功"),

    PRIMARY_SCHOOL(100,"上小学"),

    MIDDLE_SCHOOL(101,"上初中")
    ;

    private Integer code;

    private String  message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }




    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
