package sk.gabrielkostialik.garwanDemoRest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.gabrielkostialik.garwanDemoRest.mapper.ShopOrderMapper;
import sk.gabrielkostialik.garwanDemoRest.model.ShopOrder;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ShopOrderDto;
import sk.gabrielkostialik.garwanDemoRest.service.api.ShopOrderService;

@RestController
@RequestMapping("/shopOrder")
public class ShopOrderController {

    ShopOrderService shopOrderService;

    public ShopOrderController(ShopOrderService shopOrderService) {
        this.shopOrderService = shopOrderService;
    }

    @GetMapping
    public ShopOrderDto getShopOrder() {
        ShopOrder shopOrder = shopOrderService.getShopOrder();
        return ShopOrderMapper.INSTANCE.shopOrderToDTO(shopOrder);
    }
}
