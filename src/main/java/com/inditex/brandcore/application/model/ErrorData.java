package com.inditex.brandcore.application.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Error data.
 */
@Builder
@Getter
@Setter
public class ErrorData {
  private String codResponse;
  private String descResponse;
}
