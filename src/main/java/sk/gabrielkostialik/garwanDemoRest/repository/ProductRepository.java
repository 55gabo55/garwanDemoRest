package sk.gabrielkostialik.garwanDemoRest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import sk.gabrielkostialik.garwanDemoRest.model.AnimalCategory;
import sk.gabrielkostialik.garwanDemoRest.model.Product;


import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
   // List<Product> findAllByPrice(double price, Pageable pageable);
    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Page<Product> findByNameStartsWith(String token, Pageable pageable);
}
