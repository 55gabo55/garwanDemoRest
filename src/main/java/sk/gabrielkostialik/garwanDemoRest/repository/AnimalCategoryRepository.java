package sk.gabrielkostialik.garwanDemoRest.repository;

import org.springframework.data.repository.CrudRepository;
import sk.gabrielkostialik.garwanDemoRest.model.AnimalCategory;
import sk.gabrielkostialik.garwanDemoRest.model.Product;

import java.util.List;

public interface AnimalCategoryRepository extends CrudRepository<AnimalCategory, Long> {
    AnimalCategory findByName(String name);
    List<AnimalCategory> findAll();
}
