package ruida.service;

import com.ruida.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ruida.dao.ProductDao;
import ruida.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductDao productDao;
    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }

    @Override
    public Product reduceById(Integer pid,Integer number) {
        Product product =productDao.findById(pid).get();
        if(product.getStock()<number){
            throw new RuntimeException("库存不足");
        }
       // int i=100/0;
        product.setStock(product.getStock()-number);
        return productDao.save(product);
    }
}
