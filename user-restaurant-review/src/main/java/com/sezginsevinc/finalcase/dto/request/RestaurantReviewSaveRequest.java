package com.sezginsevinc.finalcase.dto.request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;


public record RestaurantReviewSaveRequest(
        @NotBlank @Length(min = 1, max = 100) String text,
        @NotNull @Positive @Min(1) @Max(5) Integer score,
        @NotBlank Long restaurantId
) {

}
