package com.sezginsevinc.finalcase.service;

import com.sezginsevinc.finalcase.client.RestaurantClient;

import java.util.List;

import com.sezginsevinc.finalcase.entity.Restaurant;
import com.sezginsevinc.finalcase.entity.RestaurantReview;
import com.sezginsevinc.finalcase.service.entityservice.RestaurantReviewEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RestaurantService {

  private final RestaurantClient restaurantClient;

  private final RestaurantReviewEntityService restaurantReviewService;

  public List<Restaurant> findAll() {
    return restaurantClient.getAllRestaurants();
  }

    public Restaurant findById(String id) {
        return restaurantClient.getRestaurantById(id);
    }

  public Long getAverageRating(Long restaurantId) {
    List<RestaurantReview> reviews = restaurantReviewService.getRestaurantReviewsByRestaurantId(restaurantId);
    if (!reviews.isEmpty()) {
      return reviews.stream().mapToLong(RestaurantReview::getScore).sum() / reviews.size();
    }
    return 0L;
  }

  public Restaurant save(Restaurant restaurant) {
    return restaurantClient.save(restaurant);
  }

    public Restaurant update(Restaurant restaurant) {
        return restaurantClient.save(restaurant);
    }
}
