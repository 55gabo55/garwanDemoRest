package sk.gabrielkostialik.garwanDemoRest.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sk.gabrielkostialik.garwanDemoRest.model.Product;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    List<Product> getAll();
    Product getProduct(long id);
    Page<Product> getAllPPageable(Pageable pageable);
    Page<Product> getAllPPageableStartsWith(String startWith, Pageable pageable);

   // public Page<Product> findBySearchTerm(String searchTerm);
}
