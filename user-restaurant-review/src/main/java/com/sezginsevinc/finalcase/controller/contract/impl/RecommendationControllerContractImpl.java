package com.sezginsevinc.finalcase.controller.contract.impl;

import com.sezginsevinc.finalcase.controller.contract.RecommendationControllerContract;
import com.sezginsevinc.finalcase.entity.Restaurant;
import com.sezginsevinc.finalcase.mapper.RestaurantMapper;
import com.sezginsevinc.finalcase.service.RecommendationService;
import com.sezginsevinc.finalcase.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RecommendationControllerContractImpl implements RecommendationControllerContract {

  private final RecommendationService recommendationService;

  @Override
  public List<Restaurant> getRecommendation(Long userId) {
    List<Restaurant> restaurantList = recommendationService.getRecommendations(userId);
    return RestaurantMapper.INSTANCE.convertToRestaurant(restaurantList);
  }
}
