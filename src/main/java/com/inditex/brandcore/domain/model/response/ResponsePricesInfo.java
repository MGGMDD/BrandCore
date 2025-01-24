package com.inditex.brandcore.domain.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The type Response prices info.
 */
@Getter
@Setter
@Builder
public class ResponsePricesInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer productId;
    private Integer brandId;
    private String priceList;
    private LocalDateTime applicationDate;
    private Double finalPrice;
}