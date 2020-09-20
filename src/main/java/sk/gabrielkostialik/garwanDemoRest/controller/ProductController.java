package sk.gabrielkostialik.garwanDemoRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sk.gabrielkostialik.garwanDemoRest.config.SpringSecurityConfig;
import sk.gabrielkostialik.garwanDemoRest.excpetion.PageOutOfLimit;
import sk.gabrielkostialik.garwanDemoRest.excpetion.ProductNotFoundException;
import sk.gabrielkostialik.garwanDemoRest.mapper.ProductMapper;
import sk.gabrielkostialik.garwanDemoRest.model.Product;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ProductDto;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ProductListDto;
import sk.gabrielkostialik.garwanDemoRest.service.api.ProductService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {

    @Autowired
    AuthenticationManagerBuilder auth;

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

  /*  @GetMapping()
    public List<ProductListDto> getProducts() {

        List<ProductListDto> productDtos = new ArrayList<>();

        for(Product product : productService.getAll()) {
            productDtos.add(ProductMapper.INSTANCE.productToListDto(product));
        }
        return productDtos;

    }*/

    @GetMapping()
    public List<ProductListDto> getAllPaginatedStartsWith(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "5") int size,
                                                          @RequestParam(defaultValue = "") String sort,
                                                          @RequestParam(defaultValue = "") String nameStartsWith
                                                ) {

        Page<Product> productPage;

        if (sort.equals("desc")) {
            productPage = productService.getAllPPageableStartsWith(nameStartsWith ,PageRequest.of(page, size, Sort.by("price").descending()));
        } else if(sort.equals("asc")) {
            productPage = productService.getAllPPageableStartsWith(nameStartsWith ,PageRequest.of(page, size, Sort.by("price").ascending()));
        } else {
            productPage = productService.getAllPPageableStartsWith(nameStartsWith ,PageRequest.of(page, size));
        }

        if(page >= productPage.getTotalPages()) {
            throw new PageOutOfLimit();
        }

        List<Product> products = productPage.getContent();

        return products.stream()
                .map(ProductMapper.INSTANCE::productToListDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable("id") @Min(1) Long id) throws Exception {
        Product product = productService.getProduct(id);

        if (product == null){
            throw new ProductNotFoundException(id);
        } else {
            return ProductMapper.INSTANCE.productToDto(product);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@Valid @RequestBody Product product) {
        productService.addProduct(product);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

