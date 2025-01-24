package com.inditex.brandcore.application.exception.error;

import com.fasterxml.jackson.annotation.JsonProperty;
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
