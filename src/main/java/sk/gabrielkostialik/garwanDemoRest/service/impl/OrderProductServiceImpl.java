package sk.gabrielkostialik.garwanDemoRest.service.impl;

import org.springframework.stereotype.Service;
import sk.gabrielkostialik.garwanDemoRest.excpetion.ProductNotFoundException;
import sk.gabrielkostialik.garwanDemoRest.model.OrderProduct;
import sk.gabrielkostialik.garwanDemoRest.model.Product;
import sk.gabrielkostialik.garwanDemoRest.model.ShopOrder;
import sk.gabrielkostialik.garwanDemoRest.repository.OrderProductRepository;
import sk.gabrielkostialik.garwanDemoRest.service.api.OrderProductService;
import sk.gabrielkostialik.garwanDemoRest.service.api.ProductService;
import sk.gabrielkostialik.garwanDemoRest.service.api.ShopOrderService;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    OrderProductRepository orderProductRepository;
    ShopOrderService shopOrderService;
    ProductService productService;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository, ShopOrderService shopOrderService, ProductService productService) {
        this.orderProductRepository = orderProductRepository;
        this.shopOrderService = shopOrderService;
        this.productService = productService;
    }

    @Override
    public void addOrderProduct(OrderProduct orderProduct) {
        ShopOrder shopOrder = shopOrderService.getShopOrder();
        orderProduct.setShopOrder(shopOrder);

        Product product = productService.getProduct(orderProduct.getProductId());

        if(product == null) {
            throw new ProductNotFoundException(orderProduct.getProductId());
        }

        orderProduct.setPrice(product.getPrice());
        OrderProduct orderProductDB = orderProductRepository.save(orderProduct);

        shopOrder.getOrderProducts().add(orderProductDB);

        shopOrderService.actualize(shopOrder);
    }
}
