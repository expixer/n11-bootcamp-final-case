package com.sezginsevinc.finalcase.controller;

import com.sezginsevinc.finalcase.controller.contract.RecommendationControllerContract;
import com.sezginsevinc.finalcase.entity.Restaurant;
import com.sezginsevinc.finalcase.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recommendations")
@RequiredArgsConstructor
public class RecommendationController {

  private final RecommendationControllerContract recommendationControllerContract;

  @GetMapping("/{userId}")
  public ResponseEntity<RestResponse<List<Restaurant>>> getAllAccounts(@PathVariable Long userId) {
    List<Restaurant> recommendations = recommendationControllerContract.getRecommendation(userId);
    return ResponseEntity.ok(RestResponse.of(recommendations));
  }

  
}
