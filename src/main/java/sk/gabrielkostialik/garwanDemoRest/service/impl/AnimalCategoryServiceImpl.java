package sk.gabrielkostialik.garwanDemoRest.service.impl;

import org.springframework.stereotype.Service;
import sk.gabrielkostialik.garwanDemoRest.model.AnimalCategory;
import sk.gabrielkostialik.garwanDemoRest.model.dto.AnimalCategoryDto;
import sk.gabrielkostialik.garwanDemoRest.repository.AnimalCategoryRepository;
import sk.gabrielkostialik.garwanDemoRest.service.api.AnimalCategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalCategoryServiceImpl implements AnimalCategoryService {

    AnimalCategoryRepository animalCategoryRepository;

    public AnimalCategoryServiceImpl(AnimalCategoryRepository animalCategoryRepository) {
        this.animalCategoryRepository = animalCategoryRepository;
    }

    @Override
    public void addAnimalCategory(AnimalCategory animalCategory) {
        animalCategoryRepository.save(animalCategory);
    }

    @Override
    public AnimalCategory getAnimalCategory(String name) {
        return animalCategoryRepository.findByName(name);
    }

    @Override
    public List<AnimalCategory> getAll() {
        return animalCategoryRepository.findAll();
    }
}
