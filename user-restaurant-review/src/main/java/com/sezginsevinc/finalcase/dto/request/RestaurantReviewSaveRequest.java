package com.sezginsevinc.finalcase.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;


public record RestaurantReviewSaveRequest(
        @NotBlank @Length(min = 1, max = 100) String text,
        @NotNull Integer score,
        @NotBlank Long restaurantId
) {

}
