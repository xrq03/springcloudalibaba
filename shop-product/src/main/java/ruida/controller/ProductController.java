package ruida.controller;

import com.ruida.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ruida.service.ProductService;
@EntityScan("com.ruida.domain")//@EntityScan("com.ruida.domain")//用来扫描和发现指定包及其子包中的Entity定义

@RestController////就是注册一个控制器，并且将响应的数据以指定的格式写入到Response的body中。
public class ProductController{
    //注入ProductService
    @Autowired
    private ProductService productService;
    @GetMapping("/prod/{pid}")//用于将HTTP GET请求映射到指定的处理方法上。
    //通过商品id查找商品信息
    public Product product(@PathVariable("pid") Integer pid){
        Product product=productService.findByPid(pid);
        return product;
    }
    @RequestMapping("/product/api001/demo1")
    public String demo1() {
        return "demo";
    }

    @RequestMapping("/product/api001/demo2")
    public String demo2() {
        return "demo2";
    }

    @RequestMapping("/product/api002/demo1")
    public String demo3() {
        return "demo3";
    }

    @RequestMapping("/product/api002/demo2")
    public String demo4() {
        return "demo4";
    }

}
