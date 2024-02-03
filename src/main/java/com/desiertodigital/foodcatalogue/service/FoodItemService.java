package com.desiertodigital.foodcatalogue.service;

import com.desiertodigital.foodcatalogue.dto.FoodCataloguePage;
import com.desiertodigital.foodcatalogue.dto.FoodItemDto;

import java.util.List;

public interface FoodItemService {

    FoodItemDto addFoodItem(FoodItemDto foodItemDto);

    List<FoodItemDto> getAllFoodItems();

    FoodCataloguePage getFoodCatalogueById(Long id);
}
