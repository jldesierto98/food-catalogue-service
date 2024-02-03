package com.desiertodigital.foodcatalogue.dto;


import lombok.*;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FoodItemDto {

    private Long id;

    private String itemName;

    private String itemDescription;

    private Boolean isVeg;

    private BigDecimal price;

    private Long restaurantId;

    private Integer quantity;
}
