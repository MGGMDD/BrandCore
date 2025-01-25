package com.inditex.brandcore.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The type Price.
 */
@Getter
@Setter
@Builder
public class Price implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer productId;
    private Double price;
    private Integer priority;
    private String curr;

}