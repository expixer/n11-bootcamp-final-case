package com.sezginsevinc.finalcase.dto.request;

import jakarta.validation.constraints.NotBlank;


public record RestaurantReviewUpdateRequest(
        @NotBlank Long id,
        @NotBlank String text,
        @NotBlank Integer score) {

}