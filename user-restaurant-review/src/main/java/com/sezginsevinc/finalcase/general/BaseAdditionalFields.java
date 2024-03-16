package com.sezginsevinc.finalcase.general;

import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Long creatorId;
  private Long updaterId;
}
