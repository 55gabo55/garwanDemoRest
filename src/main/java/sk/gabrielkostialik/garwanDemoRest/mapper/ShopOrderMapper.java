package sk.gabrielkostialik.garwanDemoRest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.gabrielkostialik.garwanDemoRest.model.ShopOrder;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ShopOrderDto;

@Mapper
public interface ShopOrderMapper {
    ShopOrderMapper INSTANCE = Mappers.getMapper(ShopOrderMapper.class);

    ShopOrderDto shopOrderToDTO(ShopOrder shopOrder);
}
