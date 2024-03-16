package com.sezginsevinc.finalcase.controller.contract;

import com.sezginsevinc.finalcase.dto.RestaurantReviewDTO;
import com.sezginsevinc.finalcase.dto.request.RestaurantReviewSaveRequest;
import com.sezginsevinc.finalcase.dto.request.RestaurantReviewUpdateRequest;

import java.util.List;


public interface RestaurantReviewControllerContract {

  RestaurantReviewDTO saveRestaurantReview(RestaurantReviewSaveRequest request);

  List<RestaurantReviewDTO> getAllRestaurantReviews();

  RestaurantReviewDTO getRestaurantReviewById(Long id);

  void deleteRestaurantReview(Long id);

  RestaurantReviewDTO updateRestaurantReview(Long id, RestaurantReviewUpdateRequest request);

}
