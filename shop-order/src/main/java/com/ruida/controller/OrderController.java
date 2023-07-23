package com.ruida.controller;

import com.alibaba.fastjson.JSON;
import com.ruida.domain.Order;
import com.ruida.domain.Product;
import com.ruida.domain.User;
import com.ruida.service.OrderService;
import com.ruida.service.ProductService;
import com.ruida.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

//Nginx
//@Slf4j注解来自动创建日志对象。
@Slf4j
//@RestController注解将该类标记为一个控制器，并且自动将返回的对象序列化为JSON响应。
@RestController
@EntityScan("com.ruida.domain")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryclient;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @GetMapping("/order/prod/{pid}/{uid}")
    public Order order(@PathVariable("pid") Integer pid,@PathVariable("uid") Integer uid) throws InterruptedException {//@PathVariable("uid") Integer uid
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
        //通过discoveryclient.getInstances("service-product")方法获取名为service-product的服务实例列表。
        //通过discoveryclient.getInstances("service-user")方法获取名为service-user的服务实例列表。
        //创建一个Random对象来生成一个随机数。
        //使用random.nextInt(instances.size())方法生成一个介于0和instances列表大小之间的随机数，作为索引从instances列表中选择一个服务实例。
        //使用random.nextInt(instances1.size())方法生成一个介于0和instances1列表大小之间的随机数，作为索引从instances1列表中选择一个服务实例。
        //从instances列表中获取选定的服务实例并赋值给serviceInstance变量。
        //从instances1列表中获取选定的服务实例并赋值给serviceInstance1变量。
        //通过serviceInstance.getHost()和serviceInstance.getPort()获取服务实例的主机和端口信息，拼接成商品微服务的URL。
        //使用restTemplate.getForObject(url, Product.class)发送HTTP GET请求来调用商品微服务，返回的结果会被转换为Product对象。
        //通过日志打印出商品信息的查询结果。
        //通过类似的方式获取用户微服务的URL，并发送HTTP GET请求来调用用户微服务。
        log.info(">>从nacos中获取到的微服务地址为:" + url1);
        Product product= productService.findById(pid);
        if (product.getPid()==-1){
            Order order=new Order();
            order.setOid(-999l);
            order.setPname("下单失败");
            return order;
        }
        //order方法使用了@GetMapping("/order/prod/{pid}/{uid}")注解，表示使用GET请求方式，路径为/order/prod/{pid}/{uid}。该方法用于处理订单下单的请求。
        //
        //在方法的实现中，首先定义了两个字符串变量url和url1，分别为"service-product"和"service-user"。这两个字符串是用于服务发现并调用微服务的服务名。
        //
        //接着通过调用productService.findById(pid)和userService.findById(uid)来分别调用商品服务和用户服务，获取相应的商品信息和用户信息。
        //
        //如果商品的pid为-1，说明获取商品信息失败，那么返回一个特殊的Order对象作为下单失败的标识。
        //
        //然后通过Thread.sleep(5000)模拟一个耗时的操作，这里设定为休眠5秒。
        //
        //接下来，创建一个Order对象，并设置相应的属性值。
        //
        //最后调用orderService.save(order)保存订单，并返回该订单对象。
        User user= userService.findById(uid);
        //User user=restTemplate.getForObject("http://"+url1+"/user/"+uid,User.class);
        Thread.sleep(5000);
        Order order=new Order();
        order.setUid(user.getUid());
        order.setUsername(user.getUsername());//
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(10);
        orderService.save(order);
        Thread.sleep(5000);
        return order;
    }
    @GetMapping("/order/message")
    public String message(){
        return "高并发测试";
    }
}