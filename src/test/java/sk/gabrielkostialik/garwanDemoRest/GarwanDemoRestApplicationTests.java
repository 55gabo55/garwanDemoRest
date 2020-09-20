package sk.gabrielkostialik.garwanDemoRest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import sk.gabrielkostialik.garwanDemoRest.mapper.AnimalCategoryMapper;
import sk.gabrielkostialik.garwanDemoRest.mapper.ProductMapper;
import sk.gabrielkostialik.garwanDemoRest.model.AnimalCategory;
import sk.gabrielkostialik.garwanDemoRest.model.Product;
import sk.gabrielkostialik.garwanDemoRest.model.User;
import sk.gabrielkostialik.garwanDemoRest.model.dto.AnimalCategoryDto;
import sk.gabrielkostialik.garwanDemoRest.model.dto.ProductDto;
import sk.gabrielkostialik.garwanDemoRest.repository.AnimalCategoryRepository;
import sk.gabrielkostialik.garwanDemoRest.service.api.AnimalCategoryService;
import sk.gabrielkostialik.garwanDemoRest.service.api.ProductService;

import java.util.ArrayList;
import java.util.List;


	@RunWith(SpringRunner.class)
	@SpringBootTest
	@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
	class GarwanDemoRestApplicationTests {

		@Autowired
		AnimalCategoryRepository animalCategoryRepository;

		@Autowired
		AnimalCategoryService animalCategoryService;

		@Autowired
		ProductService productService;

		@Test
		void DbInsertTest() {
			AnimalCategory cats = new AnimalCategory("cats");
			animalCategoryRepository.save(cats);

			AnimalCategory animalCategory = animalCategoryRepository.findByName("cats");

			Assert.assertEquals(animalCategory.getName(), cats.getName());
			Assert.assertEquals(animalCategory, cats);
		}

		@Test
		void serviceTest() {
			AnimalCategory dogs = new AnimalCategory("dogs");

			animalCategoryService.addAnimalCategory(dogs);

			List<AnimalCategory> animalCategories = animalCategoryService.getAll();

			Assert.assertEquals(1, animalCategories.size());
			Assert.assertEquals(animalCategories.get(0).getName(), dogs.getName());
		}

		@Test
		void mapperTest() {
			AnimalCategory dogs = new AnimalCategory("dogs");
			AnimalCategoryDto animalCategoryDto = AnimalCategoryMapper.INSTANCE.animalCategoryToDto(dogs);

			Assert.assertEquals(dogs.getName(), animalCategoryDto.getName());
		}
	}
