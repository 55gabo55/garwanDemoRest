package sk.gabrielkostialik.garwanDemoRest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.gabrielkostialik.garwanDemoRest.model.OrderProduct;
import sk.gabrielkostialik.garwanDemoRest.model.ShopOrder;
import sk.gabrielkostialik.garwanDemoRest.model.dto.OrderProductDto;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ShopOrderDto;

@Mapper
public interface OrderProductMapper {
    OrderProductMapper INSTANCE = Mappers.getMapper(OrderProductMapper.class);

    OrderProductDto orderProductToDTO(OrderProduct orderProduct);
}
