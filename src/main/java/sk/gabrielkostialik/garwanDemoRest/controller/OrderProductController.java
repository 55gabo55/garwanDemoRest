package sk.gabrielkostialik.garwanDemoRest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.gabrielkostialik.garwanDemoRest.model.OrderProduct;
import sk.gabrielkostialik.garwanDemoRest.model.Product;
import sk.gabrielkostialik.garwanDemoRest.service.api.OrderProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/orderProduct")
public class OrderProductController {

    OrderProductService orderProductService;

    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOrderProduct(@Valid @RequestBody OrderProduct orderProduct) {
        orderProductService.addOrderProduct(orderProduct);
    }
}




