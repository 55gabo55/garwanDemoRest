package sk.gabrielkostialik.garwanDemoRest.model.dto;

import sk.gabrielkostialik.garwanDemoRest.model.AnimalCategory;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class ProductDto {
    private Long id;
    private String name;
    private AnimalCategoryDto animalCategory;
    private int price;
    private String description;
    private ArrayList<String> gallery;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, AnimalCategoryDto animalCategoryDto, int price, String description, ArrayList<String> gallery) {
        this.id = id;
        this.name = name;
        this.animalCategory = animalCategoryDto;
        this.price = price;
        this.description = description;
        this.gallery = gallery;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getGallery() {
        return gallery;
    }

    public void setGallery(ArrayList<String> gallery) {
        this.gallery = gallery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return price == that.price &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(animalCategory, that.animalCategory) &&
                Objects.equals(description, that.description) &&
                Objects.equals(gallery, that.gallery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, animalCategory, price, description, gallery);
    }
}
