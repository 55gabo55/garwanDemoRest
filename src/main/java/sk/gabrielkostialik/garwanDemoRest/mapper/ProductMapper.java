package sk.gabrielkostialik.garwanDemoRest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.gabrielkostialik.garwanDemoRest.model.Product;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ProductDto;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ProductListDto;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto productToDto(Product product);
    Product dtoToProduct(ProductDto productDto);

    ProductListDto productToListDto(Product product);
}
