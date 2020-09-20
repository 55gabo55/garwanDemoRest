package sk.gabrielkostialik.garwanDemoRest.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sk.gabrielkostialik.garwanDemoRest.excpetion.AnimalCategoryNotFoundException;
import sk.gabrielkostialik.garwanDemoRest.excpetion.ProductNotFoundException;
import sk.gabrielkostialik.garwanDemoRest.model.Product;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ProductDto;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ProductListDto;
import sk.gabrielkostialik.garwanDemoRest.repository.AnimalCategoryRepository;
import sk.gabrielkostialik.garwanDemoRest.repository.ProductRepository;
import sk.gabrielkostialik.garwanDemoRest.service.api.AnimalCategoryService;
import sk.gabrielkostialik.garwanDemoRest.service.api.ProductService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    AnimalCategoryRepository animalCategoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, AnimalCategoryRepository animalCategoryRepository) {
        this.productRepository = productRepository;
        this.animalCategoryRepository = animalCategoryRepository;
    }

    @Override
    public void addProduct(Product product) {
        if (animalCategoryRepository.findByName(product.getAnimalCategory().getName()) != null) {
            productRepository.save(product);
        } else {
            throw new AnimalCategoryNotFoundException(product.getAnimalCategory().getName());
        }
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAllPPageable(Pageable pageable) {
         return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getAllPPageableStartsWith(String startWith, Pageable pageable) {
        return productRepository.findByNameStartsWith(startWith, pageable);
    }


    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).orElse(null);
    }
}
