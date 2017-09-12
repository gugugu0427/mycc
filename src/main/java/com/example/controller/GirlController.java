package com.example.controller;

import com.example.dao.IGirl;
import com.example.entity.Girl;
import com.example.entity.Result;
import com.example.service.GirlService;
import com.example.util.MyLogger;
import com.example.util.ResultUitil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by GuYang on 2017/9/11.
 */
@RestController
public class GirlController {

    @Autowired
    private IGirl igirl;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> getGilrs(){
        MyLogger.getLogger(GirlController.class).info("2222222222222");
       return igirl.findAll();
    }
    @PostMapping(value = "/girls")
    public Result<Girl> addGirls(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
//            return null;
          return ResultUitil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
            return  ResultUitil.success(girl);

    }

    @GetMapping(value ="/girls/{id}")
    public Girl getGirlByid(@PathVariable("id") Integer id){
        return igirl.findOne(id );
    }

    @PutMapping(value = "/girls/{id}")
    public void modifyById(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        igirl.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public  void deleterById(@PathVariable("id") Integer id){
        igirl.delete(id);
    }

    @GetMapping(value = "/getGirlsByAge/{age}")
    public List<Girl> getGirlsByAge(@PathVariable ("age") Integer age){
        List<Girl> girlByAge = igirl.findGirlByAge(age);
        return girlByAge;
    }

    @PostMapping(value = "/addTwoGirl")
    public void addTwoGirl(){
       girlService.insertTwo();
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
