package mate.academy.service;

import java.util.List;
import mate.academy.dao.ProductDao;
import mate.academy.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> findByBrand(String brand) {
        return productDao.findByBrand(brand);
    }

    @Override
    public void delete(Long id) {
        productDao.delete(id);
    }

    @Override
    public Product get(Long id) {
        return productDao.get(id);
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }
}
