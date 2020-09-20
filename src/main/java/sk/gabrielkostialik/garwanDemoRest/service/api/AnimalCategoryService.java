package sk.gabrielkostialik.garwanDemoRest.service.api;

import sk.gabrielkostialik.garwanDemoRest.model.AnimalCategory;
import sk.gabrielkostialik.garwanDemoRest.model.dto.AnimalCategoryDto;

import java.util.List;

public interface AnimalCategoryService {
    void addAnimalCategory(AnimalCategory animalCategory);
    AnimalCategory getAnimalCategory(String name);
    List<AnimalCategory> getAll();
}
