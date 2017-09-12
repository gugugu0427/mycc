package com.example.util;

import com.example.entity.Result;

/**
 * Created by GuYang on 2017/9/12.
 */
public class ResultUitil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("success");
        result.setData(object);
        return  result;
    }
    public static Result error(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        return  result;
    }
}
