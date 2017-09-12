package com.example.controller;

import com.example.entity.Girl;
import com.example.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by GuYang on 2017/9/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;
    @Test
    public void oneTest(){
        Girl girl = girlService.findOne(19);
        Assert.assertEquals(new Integer(17),girl.getAge());
    }

}
