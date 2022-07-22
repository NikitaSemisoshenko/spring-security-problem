package mate.academy.dao;

import java.util.List;
import mate.academy.model.Product;

public interface ProductDao {
    Product save(Product product);
    List<Product> getAll();

    Product get(Long id);

    void delete(Long id);

    Product update(Product product);

    List<Product> findByBrand(String brand);
}
