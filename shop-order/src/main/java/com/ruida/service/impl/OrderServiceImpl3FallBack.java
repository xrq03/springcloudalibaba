package com.ruida.service.impl;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl3FallBack {
    public static String fallback(Throwable throwable){
        return "接口异常了";
    }
}
