package com.ruida.service;

import com.ruida.domain.Product;
//import com.ruida.fegin.facback.ProductFeignFacback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(value = "service-product")
//在这段代码中，@Service注解标记了该接口是一个服务类，并且@FeignClient注解指定了该接口使用Feign进行服务调用。
//value = "service-product"：指定要调用的服务名称为 service-product。在微服务架构中，服务名称用于通过服务注册与发现进行服务调用。
//fallback = ProductFeignFacback.class：指定在调用发生错误或异常时的回退实现类为 ProductFeignFacback。回退实现类通常用于提供一个默认的返回值或处理异常情况。
public interface ProductService {
    @GetMapping(value = "/prod/{pid}")
    //接口中的方法使用了@GetMapping注解标记为使用 GET 请求方式，并且指定了 /prod/{pid} 作为请求路径。
        // @PathVariable注解用于获取请求路径中的参数值
        // 方法的返回类型为 Product，表示调用远程服务后返回的结果为 Product 对象。
    Product findById(@PathVariable("pid") Integer pid);
    @GetMapping(value = "/prod/{pid}/{number}")
    Product reduceById(@PathVariable("pid") Integer pid,@PathVariable("number") Integer number);
}
