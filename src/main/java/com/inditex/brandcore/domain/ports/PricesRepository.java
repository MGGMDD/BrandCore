package com.inditex.brandcore.domain.ports;

import com.inditex.brandcore.domain.model.Price;

import java.time.LocalDateTime;

/**
 * The interface Prices repository.
 */
public interface PricesRepository {
    /**
     * Find price by date price.
     *
     * @param applicationDate the application date
     * @param productId       the product id
     * @param brandId         the brand id
     * @return the price
     */
    Price findPriceByDate(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
