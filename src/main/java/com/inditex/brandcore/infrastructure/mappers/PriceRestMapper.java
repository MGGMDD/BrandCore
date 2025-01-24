package com.inditex.brandcore.infrastructure.mappers;

import com.inditex.brandcore.domain.model.response.ResponsePricesInfo;
import com.inditex.brandcore.infrastructure.rest.data.ResponsePricesInfoDto;
import org.mapstruct.Mapper;

/**
 * The interface Price rest mapper.
 */
@Mapper
public interface PriceRestMapper {
    /**
     * To response prices info response prices info.
     *
     * @param responsePricesInfoDto the response prices info dto
     * @return the response prices info
     */
    ResponsePricesInfo toResponsePricesInfo(ResponsePricesInfoDto responsePricesInfoDto);

    /**
     * To response prices info dto response prices info dto.
     *
     * @param responsePricesInfo the response prices info
     * @return the response prices info dto
     */
    ResponsePricesInfoDto toResponsePricesInfoDto(ResponsePricesInfo responsePricesInfo);
}
