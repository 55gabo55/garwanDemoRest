package sk.gabrielkostialik.garwanDemoRest.model.dto;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ShopOrderDto {
    private Long id;
    private int totalPrice;
    private LocalTime time;
    private Set<OrderProductDto> orderProducts = new HashSet<>();

    public ShopOrderDto() {
    }

    public ShopOrderDto(Long id, int totalPrice, LocalTime time, Set<OrderProductDto> orderProducts) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.time = time;
        this.orderProducts = orderProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Set<OrderProductDto> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProductDto> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
