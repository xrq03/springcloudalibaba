package com.ruida.service;

import com.ruida.domain.User;
import lombok.experimental.FieldDefaults;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//在这段代码中，@FeignClient注解标记了该接口使用Feign来调用名为service-user的服务。
@FeignClient("service-user")
public interface UserService {
    //@GetMapping注解来标记使用GET请求方式，并指定了/user/{uid}作为请求路径。
    // @PathVariable注解用于获取请求路径中的参数值。
    //方法的返回类型是User，表示调用远程服务后返回的结果是一个User对象。
    @GetMapping("/user/{uid}")
    User findById(@PathVariable("uid") Integer uid);
}
