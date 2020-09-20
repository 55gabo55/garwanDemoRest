package sk.gabrielkostialik.garwanDemoRest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sk.gabrielkostialik.garwanDemoRest.excpetion.AnimalCategoryNotFoundException;
import sk.gabrielkostialik.garwanDemoRest.excpetion.ProductNotFoundException;
import sk.gabrielkostialik.garwanDemoRest.mapper.AnimalCategoryMapper;
import sk.gabrielkostialik.garwanDemoRest.mapper.ProductMapper;
import sk.gabrielkostialik.garwanDemoRest.model.AnimalCategory;
import sk.gabrielkostialik.garwanDemoRest.model.Product;
import sk.gabrielkostialik.garwanDemoRest.model.dto.AnimalCategoryDto;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ProductDto;
import sk.gabrielkostialik.garwanDemoRest.service.api.AnimalCategoryService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/animalCategories")
public class AnimalCategoryController {

    AnimalCategoryService animalCategoryService;

    public AnimalCategoryController(AnimalCategoryService animalCategoryService) {
        this.animalCategoryService = animalCategoryService;
    }

    @GetMapping
    public List<AnimalCategoryDto> getAll() {
        List<AnimalCategory> animalCategories = animalCategoryService.getAll();

        return animalCategories.stream()
                .map(AnimalCategoryMapper.INSTANCE::animalCategoryToDto)
                .collect(Collectors.toList());
    }


    @GetMapping("/{name}")
    public AnimalCategoryDto getProduct(@PathVariable("name") String name) throws Exception {
        AnimalCategory animalCategory = animalCategoryService.getAnimalCategory(name);

        if (animalCategory == null){
            throw new AnimalCategoryNotFoundException(name);
        } else {
            return AnimalCategoryMapper.INSTANCE.animalCategoryToDto(animalCategory);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@Valid @RequestBody AnimalCategory animalCategory) {
        animalCategoryService.addAnimalCategory(animalCategory);
    }
}
