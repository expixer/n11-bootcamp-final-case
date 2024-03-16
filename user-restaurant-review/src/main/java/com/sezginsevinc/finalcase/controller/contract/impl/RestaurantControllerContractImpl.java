package com.sezginsevinc.finalcase.controller.contract.impl;

import com.sezginsevinc.finalcase.controller.contract.RestaurantControllerContract;
import com.sezginsevinc.finalcase.entity.Restaurant;
import com.sezginsevinc.finalcase.mapper.RestaurantMapper;

import java.util.List;

import com.sezginsevinc.finalcase.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RestaurantControllerContractImpl implements RestaurantControllerContract {

    private final RestaurantService restaurantService;

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurantList = restaurantService.findAll();
        return RestaurantMapper.INSTANCE.convertToRestaurant(restaurantList);
    }

    @Override
    public Restaurant getRestaurantById(String id) {
        return restaurantService.findById(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }
}
