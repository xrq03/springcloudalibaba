package com.ruida.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl3 {
   @Autowired
            OrderServiceimpl3BlockHandler orderServiceimpl3BlockHandler;
    int i=0;
    @SentinelResource(
            value="message",  //资源名
            blockHandler ="blockHandler",  //指发生blockException时候要执行的方法
            blockHandlerClass = OrderServiceimpl3BlockHandler.class,
            fallbackClass = OrderServiceImpl3FallBack.class,
            fallback ="fallback"      //表示发生Throwable时候要执行的方法
    )
    public String message(){
//        i++;
//    if(i%3==0){
//        throw new RuntimeException();
//    }
    return "message";
    }
//    public String blockHandler(BlockException ex){
//        return "接口被限流或者降级了";
//
//    }
//    public String fallback(Throwable throwable){
//        return "接口异常了";
//    }

}
