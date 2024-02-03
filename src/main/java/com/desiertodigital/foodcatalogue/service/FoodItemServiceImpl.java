package com.desiertodigital.foodcatalogue.service;


import com.desiertodigital.foodcatalogue.dto.FoodCataloguePage;
import com.desiertodigital.foodcatalogue.dto.FoodItemDto;
import com.desiertodigital.foodcatalogue.dto.RestaurantDto;
import com.desiertodigital.foodcatalogue.entity.FoodItem;
import com.desiertodigital.foodcatalogue.mapper.FoodItemMapper;
import com.desiertodigital.foodcatalogue.repository.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodItemServiceImpl implements FoodItemService{

    private final FoodItemRepository foodItemRepository;
    private final RestTemplate restTemplate;

    @Override
    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem savedFoodItem = foodItemRepository.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDto));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(savedFoodItem);
    }

    @Override
    public List<FoodItemDto> getAllFoodItems() {
        List<FoodItem> foodItemsList = foodItemRepository.findAll();
        return foodItemsList.stream()
                .map(foodItem -> FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItem))
                .collect(Collectors.toList());
    }

    @Override
    public FoodCataloguePage getFoodCatalogueById(Long restaurantId) {
        List<FoodItem> foodItemList = foodItemRepository.findByRestaurantId(restaurantId);
        RestaurantDto fetchedRestaurantDto = this.getRestaurantDetailsFromRestaurantMicroService(restaurantId);

        return FoodCataloguePage
                .builder()
                .foodItemList(foodItemList)
                .restaurantDto(fetchedRestaurantDto)
                .build();
    }

    private RestaurantDto getRestaurantDetailsFromRestaurantMicroService(Long restaurantId){
        //Get restaurant by ID
        return restTemplate.getForObject("http://DESIERTO-RESTO-SERVICE/restaurant/"+restaurantId.toString(), RestaurantDto.class);
    }
}
