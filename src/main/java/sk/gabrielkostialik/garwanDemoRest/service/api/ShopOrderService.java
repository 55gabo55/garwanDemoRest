package sk.gabrielkostialik.garwanDemoRest.service.api;

import sk.gabrielkostialik.garwanDemoRest.model.OrderProduct;
import sk.gabrielkostialik.garwanDemoRest.model.ShopOrder;

public interface ShopOrderService {
    ShopOrder getShopOrder();
    ShopOrder addShopOrder();
    void actualize(ShopOrder shopOrder);
}
