package com.ruida.service.impl;

import com.ruida.dao.OrderDao;
import com.ruida.domain.Order;
import com.ruida.domain.Product;
import com.ruida.domain.User;
import com.ruida.service.OrderService;
import com.ruida.service.ProductService;
import com.ruida.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class OrderServiceImpl5  {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    public Order order(@RequestParam("pid") Integer pid, @RequestParam("uid") Integer uid, @RequestParam("number") Integer number) throws Exception {
        Product product= productService.findById(pid);
        User user= userService.findById(uid);
        //User user=restTemplate.getForObject("http://"+url1+"/user/"+uid,User.class);
        //Thread.sleep(5000);
        Order order=new Order();
        order.setUid(user.getUid());
        order.setUsername(user.getUsername());//
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(number);
        orderService.save(order);
        int i=10/0;
        productService.reduceById(order.getPid(),order.getNumber());
        //rocketMQTemplate.convertAndSend("order-topic",order);
        //Thread.sleep(5000);
        return order;
    }
}
