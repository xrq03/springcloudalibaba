package com.ruida.controller;

import com.ruida.domain.Order;
import com.ruida.domain.Product;
import com.ruida.domain.User;
import com.ruida.service.OrderService;
import com.ruida.service.ProductService;
import com.ruida.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
//@RestController
@EntityScan("com.ruida.domain")
public class OrderController2 {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @GetMapping("/order/prod/{pid}/{uid}")
    public Order order(@PathVariable("pid") Integer pid, @PathVariable("uid") Integer uid) throws InterruptedException {//@PathVariable("uid") Integer uid
        //List<ServiceInstance> instances = discoveryclient.getInstances("service-product");
        //List<ServiceInstance> instances1 = discoveryclient.getInstances("service-user");
        //Random random=new Random();
        //int i=random.nextInt(instances.size());
        //int i1=random.nextInt(instances1.size());
        //ServiceInstance serviceInstance=instances.get(i);
        //ServiceInstance serviceInstance1=instances1.get(i1);
        // log.info(">>客户下单，这时候要调用商品微服务查询商品信息");
        String url=//"http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/prod/"+pid;
                "service-product";
        //log.info(">>从nacos中获取到的微服务地址为:" + url);
        //Product product=restTemplate.getForObject("http://"+url+"/prod/"+pid,Product.class);
        //log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));
        String url1=//"http://"+serviceInstance1.getHost()+":"+serviceInstance1.getPort()+"/user/"+uid;
                "service-user";
        log.info(">>从nacos中获取到的微服务地址为:" + url1);
        Product product= productService.findById(pid);
        User user= userService.findById(uid);
        //User user=restTemplate.getForObject("http://"+url1+"/user/"+uid,User.class);
        Thread.sleep(3000);
        Order order=new Order();
        order.setUid(user.getUid());
        order.setUsername(user.getUsername());//
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(10);
        orderService.save(order);
        return order;
    }
    @GetMapping("/order/message")
    public String message(){
        return "高并发测试";
    }
}
