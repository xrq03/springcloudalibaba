//package com.ruida.fegin.facback;
//
//import com.ruida.domain.Product;
//import com.ruida.service.ProductService;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProductFeignFacback implements ProductService {
//    @Override
//    public Product findById(Integer pid) {
//        Product product=new Product();
//        product.setPid(-1);
//        product.setPname("服务异常，进入容错逻辑");
//        return product;
//    }
//}
