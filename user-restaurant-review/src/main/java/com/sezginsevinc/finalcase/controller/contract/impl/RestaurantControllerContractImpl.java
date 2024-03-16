package com.sezginsevinc.finalcase.controller.contract.impl;

import com.sezginsevinc.finalcase.controller.contract.RestaurantControllerContract;
import com.sezginsevinc.finalcase.entity.Restaurant;
import com.sezginsevinc.finalcase.mapper.RestaurantMapper;

import java.util.List;

import com.sezginsevinc.finalcase.service.entity.RestaurantEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RestaurantControllerContractImpl implements RestaurantControllerContract {

    private final RestaurantEntityService restaurantEntityService;

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurantList = restaurantEntityService.findAll();
        return RestaurantMapper.INSTANCE.convertToRestaurant(restaurantList);
    }

    @Override
    public Restaurant getRestaurantById(String id) {
        return restaurantEntityService.findById(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantEntityService.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return restaurantEntityService.update(restaurant);
    }
}
