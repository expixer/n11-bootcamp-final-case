package com.sezginsevinc.finalcase.dto;

import java.time.LocalDate;

public record CustomerDTO(Long id,
                          String name,
                          String surname,
                          LocalDate birthDate,
                          String username,
                          String identityNo,
                          String phoneNumber,
                          String email
) {

}
