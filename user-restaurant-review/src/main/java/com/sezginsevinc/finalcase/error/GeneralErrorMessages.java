package com.sezginsevinc.finalcase.error;

import java.time.LocalDateTime;


public record GeneralErrorMessages(LocalDateTime date, String message, String description) {

}
