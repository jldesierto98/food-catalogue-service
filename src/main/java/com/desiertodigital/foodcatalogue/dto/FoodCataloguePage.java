package com.desiertodigital.foodcatalogue.dto;


import com.desiertodigital.foodcatalogue.entity.FoodItem;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FoodCataloguePage {

    private List<FoodItem> foodItemList;

    private RestaurantDto restaurantDto;
}
