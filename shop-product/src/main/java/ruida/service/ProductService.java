package ruida.service;

import com.ruida.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
//
//@FeignClient(value = "service-product",fallback = ProductFeignFacback.cl)
public interface ProductService {
    Product findByPid(Integer pid);
}