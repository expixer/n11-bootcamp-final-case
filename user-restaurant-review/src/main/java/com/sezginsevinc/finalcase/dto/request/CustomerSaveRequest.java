package com.sezginsevinc.finalcase.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;


public record CustomerSaveRequest(
        @NotBlank(message = "Name cannot be blank")
        @Length(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
        String name,

        @NotBlank(message = "Surname cannot be blank")
        String surname,

        @NotNull(message = "Birth date cannot be null")
        @Past(message = "Birth date must be in the past")
        LocalDate birthDate,

        @NotBlank(message = "Username cannot be blank")
        @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username must contain only letters, numbers and underscores") // only letters, numbers and underscores
        String username,

        @NotBlank(message = "Identity number cannot be blank")
        @Length(min = 11, max = 11, message = "Identity number must be 11 digits")
        String identityNo,

        @NotBlank(message = "Password cannot be blank")
        // At least 8 characters long, at least one digit, one lowercase letter, one uppercase letter and one special character
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Password must be at least 8 characters long, at least one digit, one lowercase letter, one uppercase letter and one special character")
        String password,

        @NotBlank(message = "Phone number cannot be blank")
        // only digits and optionally start with a plus sign
        @Pattern(regexp = "^(\\+)?[0-9]+$", message = "Phone number must contain only digits and optionally start with a plus sign")
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
