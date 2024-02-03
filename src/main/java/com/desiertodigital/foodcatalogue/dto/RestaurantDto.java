package com.desiertodigital.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantDto {

    private Long id;

    private String name;

    private String address;

    private String city;

    private String restaurantDescription;

}
