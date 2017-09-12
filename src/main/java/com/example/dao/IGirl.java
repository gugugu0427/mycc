package com.example.dao;

import com.example.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by GuYang on 2017/9/11.
 */
public interface IGirl extends JpaRepository<Girl,Integer>{
     List<Girl> findGirlByAge(Integer age);
}
