package com.desiertodigital.foodcatalogue.mapper;

import com.desiertodigital.foodcatalogue.dto.FoodItemDto;
import com.desiertodigital.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);

    FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItem);
}
