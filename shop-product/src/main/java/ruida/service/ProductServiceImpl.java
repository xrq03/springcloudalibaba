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
}
