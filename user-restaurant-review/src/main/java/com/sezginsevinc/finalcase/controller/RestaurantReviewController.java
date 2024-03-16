package com.sezginsevinc.finalcase.controller;

import com.sezginsevinc.finalcase.controller.contract.RestaurantReviewControllerContract;
import com.sezginsevinc.finalcase.dto.RestaurantReviewDTO;
import com.sezginsevinc.finalcase.dto.request.RestaurantReviewSaveRequest;
import com.sezginsevinc.finalcase.dto.request.RestaurantReviewUpdateRequest;
import com.sezginsevinc.finalcase.general.RestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/restaurants/reviews")
@Validated
@Tag(name = "RestaurantReview Controller", description = "Restaurant Review")
@RequiredArgsConstructor
public class RestaurantReviewController {

  private final RestaurantReviewControllerContract restaurantReviewControllerContract;

  @GetMapping
  @Operation(summary = "Get all customers", description = "Retrieves all active customers")
  public ResponseEntity<RestResponse<List<RestaurantReviewDTO>>> getAllRestaurantReviews() {
    List<RestaurantReviewDTO> allRestaurantReviews = restaurantReviewControllerContract.getAllRestaurantReviews();
    return ResponseEntity.ok(RestResponse.of(allRestaurantReviews));
  }

  @GetMapping("/{id}")
  public ResponseEntity<RestResponse<RestaurantReviewDTO>> getRestaurantReviewById(@PathVariable @Positive Long id) {
    RestaurantReviewDTO customerById = restaurantReviewControllerContract.getRestaurantReviewById(id);
    return ResponseEntity.ok(RestResponse.of(customerById));
  }

  @PostMapping
  public ResponseEntity<RestResponse<RestaurantReviewDTO>> saveRestaurantReview(@Valid @RequestBody RestaurantReviewSaveRequest request) {
    RestaurantReviewDTO customerDTO = restaurantReviewControllerContract.saveRestaurantReview(request);
    return ResponseEntity.ok(RestResponse.of(customerDTO));
  }

  @DeleteMapping("/{id}")
  public void deleteRestaurantReview(@PathVariable @NotNull Long id) {
    restaurantReviewControllerContract.deleteRestaurantReview(id);
  }
}
