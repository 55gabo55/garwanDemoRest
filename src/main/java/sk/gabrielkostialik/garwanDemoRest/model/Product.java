package sk.gabrielkostialik.garwanDemoRest.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products", nullable = false)
   // @NotEmpty(message = "Animal category is mandatory")
    private AnimalCategory animalCategory;

    @NotNull(message = "Price is mandatory")
    @DecimalMin("0.01")
    private int price;
    private String description;
    private ArrayList<String> gallery;

    public Product() {
    }

    public Product(String name, AnimalCategory animalCategory, int price, String description, ArrayList<String> gallery) {
        this.name = name;
        this.animalCategory = animalCategory;
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

    public AnimalCategory getAnimalCategory() {
        return animalCategory;
    }

    public void setAnimalCategory(AnimalCategory animalCategory) {
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
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(animalCategory, product.animalCategory) &&
                Objects.equals(description, product.description) &&
                Objects.equals(gallery, product.gallery);
    }
}
