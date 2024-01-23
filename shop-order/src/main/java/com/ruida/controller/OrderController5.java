package com.ruida.controller;

import com.ruida.domain.Order;
import com.ruida.domain.Product;
import com.ruida.domain.User;
import com.ruida.service.OrderService;
import com.ruida.service.ProductService;
import com.ruida.service.UserService;
import com.ruida.service.impl.OrderServiceImpl5;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@EntityScan("com.ruida.domain")
@RestController
public class OrderController5 {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderServiceImpl5 orderServiceImpl5;
//    @Autowired
//    private OrderServiceImpl5 orderServiceImpl5;
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
//    @Autowired
//    private OrderServiceImpl5 orderServiceImpl5;
    @GlobalTransactional
    @GetMapping("/order/prod/{pid}/{uid}/{number}")
    public Order order(@PathVariable("pid") Integer pid, @PathVariable("uid") Integer uid,@PathVariable("number") Integer number) throws Exception {
        //Product product= productService.findById(pid);
       return   orderServiceImpl5.order(pid,uid,number);

    }
}
