package com.desiertodigital.foodcatalogue.controller;


import com.desiertodigital.foodcatalogue.dto.FoodCataloguePage;
import com.desiertodigital.foodcatalogue.dto.FoodItemDto;
import com.desiertodigital.foodcatalogue.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
@RequiredArgsConstructor
@CrossOrigin
public class FoodCatalogueController {

    private final FoodItemService foodItemService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto){
        FoodItemDto savedFoodItem = foodItemService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(savedFoodItem, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<FoodItemDto>> getAllFoodItems(){
        List<FoodItemDto> foodItems = foodItemService.getAllFoodItems();
        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }

    @GetMapping("/restaurantAndFood/{id}")
    public ResponseEntity<FoodCataloguePage> getFoodCatalogueById(@PathVariable("id") Long id){
        FoodCataloguePage foodCataloguePage = foodItemService.getFoodCatalogueById(id);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
    }
}
