package com.sezginsevinc.finalcase.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * @author bahadirmemis
 */
public record CustomerUpdatePasswordRequest(
        @NotBlank String oldPass,
        @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
                message = "Password must be at least 8 characters long and contain at least one digit, one lowercase letter, one uppercase letter and one special character"
        ) // At least 8 characters long, at least one digit, one lowercase letter, one uppercase letter and one special character
        String newPass,
        @NotBlank String newPass2
) {

}