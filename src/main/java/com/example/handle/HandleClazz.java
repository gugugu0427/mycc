package com.example.handle;

import com.example.entity.MyExcepetion;
import com.example.entity.Result;
import com.example.util.ResultUitil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by GuYang on 2017/9/12.
 */
@ControllerAdvice
public class HandleClazz {

    private static final Logger looger = LoggerFactory.getLogger(HandleClazz.class);
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e){
        if(e instanceof MyExcepetion){
            return ResultUitil.error(((MyExcepetion) e).getCode(),e.getMessage());
        }
        looger.info("异常信息{}",e.getMessage());
     return ResultUitil.error(-1,"未知错误");
    }
}
