package com.example.service;

import com.example.entity.Girl;
import com.example.dao.IGirl;
import com.example.entity.MyExcepetion;
import com.example.entity.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by GuYang on 2017/9/12.
 */
@Service
public class GirlService {
    @Autowired
    IGirl girl;
    @Transactional
    public void insertTwo(){
        Girl gi = new Girl();
        gi.setCupSize("Z");
        gi.setAge(18);
        girl.save(gi);

        Girl gi2 = new Girl();
        gi2.setAge(20);
        gi2.setCupSize("R");
        girl.save(gi2);
    }

    public void getAge(Integer id) throws Exception {
        Girl gi = girl.findOne(id);
        Integer age = gi.getAge();
        if(age<13){
            throw new MyExcepetion(ResultCode.MIDDLE_SCHOOL);
        }else  if(age>13&&age<16){
            throw  new MyExcepetion(ResultCode.PRIMARY_SCHOOL);
        }else{
            throw new MyExcepetion(ResultCode.SUCCESS);
        }
    }
}
