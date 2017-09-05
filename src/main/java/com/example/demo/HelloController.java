package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by GuYang on 2017/8/31.
 */
@RestController
public class HelloController {
    @Autowired
    private Girl girl;

    @RequestMapping(value = "/hello",method= RequestMethod.GET)
    public String say(){
        return girl.getCupSize()+girl.getAge();
    }
}
