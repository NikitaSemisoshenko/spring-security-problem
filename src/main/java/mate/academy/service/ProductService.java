package mate.academy.service;

import java.util.List;
import mate.academy.model.Product;

public interface ProductService {
    Product save(Product product);
    List<Product> getAll();

    List<Product> findByBrand(String brand);

    void delete(Long id);

    Product get(Long id);

    Product update(Product product);
}
