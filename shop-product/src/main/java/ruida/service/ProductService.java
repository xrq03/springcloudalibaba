package ruida.service;

import com.ruida.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
//
@FeignClient(value = "service-product")
public interface ProductService {
    Product findByPid(Integer pid);
    Product reduceById(Integer pid,Integer number);
}