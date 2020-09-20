package sk.gabrielkostialik.garwanDemoRest.model;

import javax.persistence.*;


@Entity
public class OrderProduct {
    @Id
    @GeneratedValue
    private Long id;

    private long productId;
    int price;
    int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderProducts", nullable = false)
    ShopOrder shopOrder;

    public OrderProduct() {
    }

    public OrderProduct(Long id, long productId, int price, int count, ShopOrder shopOrder) {
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.count = count;
        this.shopOrder = shopOrder;
    }


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public ShopOrder getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(ShopOrder shopOrder) {
        this.shopOrder = shopOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
