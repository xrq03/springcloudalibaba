package com.ruida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication//简化了配置和启动Spring Boot应用程序的过程
@EnableDiscoveryClient//用于启用服务注册与发现功能
@EnableFeignClients//启用feign客户端；扫描和注册feign客户端bean定义
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
    //在这个代码片段中，使用了@Bean注解来告诉Spring容器将restTemplate()方法返回的对象注册为一个Bean。
    // @LoadBalanced注解用于启用负载均衡功能，它会在可用的RestTemplate实例之间进行均衡分配请求。
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
