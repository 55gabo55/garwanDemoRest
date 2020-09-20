package sk.gabrielkostialik.garwanDemoRest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.gabrielkostialik.garwanDemoRest.model.AnimalCategory;
import sk.gabrielkostialik.garwanDemoRest.model.dto.AnimalCategoryDto;

@Mapper
public interface AnimalCategoryMapper {
    AnimalCategoryMapper INSTANCE = Mappers.getMapper(AnimalCategoryMapper.class);

    AnimalCategoryDto animalCategoryToDto(AnimalCategory animalCategory);
    AnimalCategory dtoToAnimalCategory(AnimalCategoryDto animalCategoryDto);
}
