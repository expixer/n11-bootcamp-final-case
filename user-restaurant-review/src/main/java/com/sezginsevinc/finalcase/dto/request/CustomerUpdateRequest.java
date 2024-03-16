package com.sezginsevinc.finalcase.dto.request;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;


public record CustomerUpdateRequest(
        @NotNull @Positive Long id,
        @NotBlank(message = "Name cannot be blank")
        @Length(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
        String name,

        @NotBlank(message = "Surname cannot be blank")
        String surname,

        @NotNull(message = "Birth date cannot be null")
        @Past(message = "Birth date must be in the past")
        LocalDate birthDate,

        @NotBlank(message = "Phone number cannot be blank")
        @Pattern(regexp = "^\\+?\\d+$", message = "Phone number must contain only digits and optionally start with a plus sign") // only digits and optionally start with a plus sign
        String phoneNumber,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Email must be a valid email address")
        String email,

        @NotNull(message = "Latitude cannot be null")
        BigDecimal latitude,

        @NotNull(message = "Longitude cannot be null")
        BigDecimal longitude
) {

}
