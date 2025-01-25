package com.inditex.brandcore.infrastructure.mappers;

import com.inditex.brandcore.domain.model.Price;
import com.inditex.brandcore.domain.model.response.ResponsePricesInfo;
import com.inditex.brandcore.infrastructure.persistence.PriceEntity;
import com.inditex.brandcore.infrastructure.rest.data.ResponsePricesInfoDto;
import org.mapstruct.Mapper;

/**
 * The interface Price mapper.
 */
@Mapper
public interface PriceMapper {
    /**
     * To price entity price entity.
     *
     * @param price the price
     * @return the price entity
     */
    PriceEntity toPriceEntity(Price price);

    /**
     * To price price.
     *
     * @param priceEntity the price entity
     * @return the price
     */
    Price toPrice(PriceEntity priceEntity);
}
