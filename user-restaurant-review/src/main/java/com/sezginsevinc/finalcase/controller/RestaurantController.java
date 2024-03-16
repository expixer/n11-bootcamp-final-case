package com.sezginsevinc.finalcase.controller;

import com.sezginsevinc.finalcase.controller.contract.RestaurantControllerContract;
import com.sezginsevinc.finalcase.entity.Restaurant;
import com.sezginsevinc.finalcase.general.RestResponse;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantControllerContract restaurantControllerContract;

    @GetMapping
    public ResponseEntity<RestResponse<List<Restaurant>>> getAllAccounts() {
        List<Restaurant> accounts = restaurantControllerContract.getAllRestaurants();
        return ResponseEntity.ok(RestResponse.of(accounts));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<Restaurant>> getRestaurantById(@PathVariable String id) {
        Restaurant restaurant = restaurantControllerContract.getRestaurantById(id);
        return ResponseEntity.ok(RestResponse.of(restaurant));
    }

    @PostMapping
    public ResponseEntity<RestResponse<Restaurant>> save(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(RestResponse.of(restaurantControllerContract.save(restaurant)));
    }

}
