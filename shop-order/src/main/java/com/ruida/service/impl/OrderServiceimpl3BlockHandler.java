package com.ruida.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceimpl3BlockHandler {

      public  static String blockHandler(String name,BlockException e){
          return "接口被限流或者降级了";

  }

}