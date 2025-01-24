package com.inditex.brandcore.application.usecases;

import com.inditex.brandcore.domain.model.response.ResponsePricesInfo;

import java.time.LocalDateTime;

/**
 * The interface Calculate price use case.
 */
public interface CalculatePriceUseCase {
    /**
     * Call to prices info response prices info.
     *
     * @param applicationDate the application date
     * @param productId  the product id
     * @param brandId    the brand id
     * @return the response prices info
     */
    ResponsePricesInfo callToPricesInfo(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
