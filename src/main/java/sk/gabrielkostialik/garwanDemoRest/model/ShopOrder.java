package sk.gabrielkostialik.garwanDemoRest.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShopOrder {
    @Id
    @GeneratedValue
    private Long id;
    private int totalPrice;
    private LocalTime time;

    private String user;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "shopOrder")
    private Set<OrderProduct> orderProducts = new HashSet<>();

    public ShopOrder() {
    }

    public ShopOrder(Long id, int totalPrice, LocalTime time, String user, Set<OrderProduct> orderProducts) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.time = time;
        this.user = user;
        this.orderProducts = orderProducts;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
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

}
