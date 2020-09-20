package sk.gabrielkostialik.garwanDemoRest.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sk.gabrielkostialik.garwanDemoRest.model.OrderProduct;
import sk.gabrielkostialik.garwanDemoRest.model.ShopOrder;
import sk.gabrielkostialik.garwanDemoRest.repository.ShopOrderRepository;
import sk.gabrielkostialik.garwanDemoRest.service.api.ShopOrderService;

import java.time.LocalTime;


@Service
public class ShopOrderServiceImpl implements ShopOrderService {

    ShopOrderRepository shopOrderRepository;

    public ShopOrderServiceImpl(ShopOrderRepository shopOrderRepository) {
        this.shopOrderRepository = shopOrderRepository;
    }

    @Override
    public ShopOrder getShopOrder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        ShopOrder shopOrder = shopOrderRepository.findByUser(currentPrincipalName);
        if (shopOrder == null) {
            return addShopOrder();
        } else {
            return shopOrder;
        }
    }

    @Override
    public ShopOrder addShopOrder() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        ShopOrder shopOrder = new ShopOrder();

        shopOrder.setTime(LocalTime.now());
        shopOrder.setTotalPrice(0);
        shopOrder.setUser(currentPrincipalName);

        return shopOrderRepository.save(shopOrder);
    }

    @Override
    public void actualize(ShopOrder shopOrder) {
        int totalPrice = 0;
        for(OrderProduct  orderProduct: shopOrder.getOrderProducts()) {
            totalPrice += orderProduct.getCount() * orderProduct.getPrice();
        }

        shopOrder.setTotalPrice(totalPrice);
        shopOrderRepository.save(shopOrder);
    }
}
