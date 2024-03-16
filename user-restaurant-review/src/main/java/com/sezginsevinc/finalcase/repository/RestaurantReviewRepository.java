package com.sezginsevinc.finalcase.repository;

import com.sezginsevinc.finalcase.entity.RestaurantReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RestaurantReviewRepository extends JpaRepository<RestaurantReview, Long> {

    List<RestaurantReview> findByRestaurantId(Long restaurantId);
}
