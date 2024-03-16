package com.sezginsevinc.finalcase.client;

import com.sezginsevinc.finalcase.entity.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "restaurant", url = "http://localhost:8081/api/v1/restaurants")
public interface RestaurantClient {

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);

    @GetMapping
    List<Restaurant> getAllRestaurants();

    @GetMapping("/{id}")
    Restaurant getRestaurantById(@PathVariable String id);

    @PostMapping
    Restaurant save(Restaurant restaurant);
}
