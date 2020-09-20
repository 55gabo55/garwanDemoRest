package sk.gabrielkostialik.garwanDemoRest.model.dto;

import java.util.ArrayList;

public class ProductListDto {
    private Long id;
    private String name;
    private AnimalCategoryDto animalCategory;
    private int price;

    public ProductListDto() {
    }

    public ProductListDto(Long id, String name, AnimalCategoryDto animalCategory, int price) {
        this.id = id;
        this.name = name;
        this.animalCategory = animalCategory;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalCategoryDto getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(AnimalCategoryDto animalCategory) {
        this.animalCategory = animalCategory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
