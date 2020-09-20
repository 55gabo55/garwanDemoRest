package sk.gabrielkostialik.garwanDemoRest.repository;

import org.springframework.data.repository.CrudRepository;
import sk.gabrielkostialik.garwanDemoRest.model.ShopOrder;

import java.util.List;

public interface ShopOrderRepository extends CrudRepository<ShopOrder, Long> {
    ShopOrder findByUser(String user);
    List<ShopOrder> findAll();
}
