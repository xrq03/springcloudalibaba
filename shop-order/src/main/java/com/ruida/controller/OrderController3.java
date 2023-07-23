package com.ruida.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ruida.service.impl.OrderServiceImpl3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Slf4j
public class OrderController3 {
    int i=0;
    @Autowired
    private OrderServiceImpl3 orderServiceImpl3;
    //定义两个方法
    @RequestMapping("/order/message1")
    public String message1(){
       // orderServiceImpl3.message();
        return "messages1";
    }
    @RequestMapping("/order/message2")
    public String message2(){

//            throw new RuntimeException();
//      //  orderServiceImpl3.message();
        return "messages2";
    }
    @RequestMapping("/order/message3")
    @SentinelResource("message3")
    public String message3(String name,Integer age){
        return "message3"+name+age;
    }
    @RequestMapping("/order/message")
    public String message(){
        return orderServiceImpl3.message();
    }
}
