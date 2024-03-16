package com.sezginsevinc.finalcase.controller.contract;

import com.sezginsevinc.finalcase.entity.Restaurant;

import java.util.List;


public interface RecommendationControllerContract {

  List<Restaurant> getRecommendation(Long userId);
}
