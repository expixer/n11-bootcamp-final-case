package com.sezginsevinc.finalcase.error.errormessage;

import com.sezginsevinc.finalcase.general.BaseErrorMessage;
import lombok.Getter;


@Getter
public enum RestaurantReviewErrorMessage implements BaseErrorMessage {

  INVALID_OLD_PASSWORD("Invalid old password!"),
  NEW_PASSWORDS_DID_NOT_MATCH("New passwords did not match");

  private final String message;

  RestaurantReviewErrorMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return message;
  }
}
