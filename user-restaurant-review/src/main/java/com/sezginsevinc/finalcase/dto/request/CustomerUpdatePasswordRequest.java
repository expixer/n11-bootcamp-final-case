package com.sezginsevinc.finalcase.dto.request;

import jakarta.validation.constraints.NotBlank;

/**
 * @author bahadirmemis
 */
public record CustomerUpdatePasswordRequest(@NotBlank String oldPass,
                                            @NotBlank String newPass,
                                            @NotBlank String newPass2) {

}