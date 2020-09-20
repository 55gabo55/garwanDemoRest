package sk.gabrielkostialik.garwanDemoRest.repository;

import org.springframework.data.repository.CrudRepository;
import sk.gabrielkostialik.garwanDemoRest.model.OrderProduct;
import sk.gabrielkostialik.garwanDemoRest.model.ShopOrder;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
}
