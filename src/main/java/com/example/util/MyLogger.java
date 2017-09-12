package com.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by GuYang on 2017/9/12.
 */
public class MyLogger {
    public static Logger getLogger(Class clazz){
        return LoggerFactory.getLogger(clazz);
    }
}
