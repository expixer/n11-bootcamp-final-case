package com.sezginsevinc.finalcase.controller.contract;

import com.sezginsevinc.finalcase.entity.Restaurant;

import java.util.List;


public interface RestaurantControllerContract {

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(String id);

    Restaurant save(Restaurant restaurant);

    Restaurant update(Restaurant restaurant);
}
