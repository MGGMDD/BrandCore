package com.inditex.brandcore.infrastructure.rest;


import com.inditex.brandcore.application.usecases.CalculatePriceUseCase;
import com.inditex.brandcore.domain.model.response.ResponsePricesInfo;
import com.inditex.brandcore.infrastructure.mappers.PriceRestMapper;
import com.inditex.brandcore.infrastructure.rest.data.ResponsePricesInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

/**
 * The type Price controller.
 */
@RestController
@RequiredArgsConstructor
public class PriceController  implements PricesApi{
    private final CalculatePriceUseCase calculatePriceUseCase;
    private final PriceRestMapper priceRestMapper;

    @Override
    public ResponseEntity<ResponsePricesInfoDto> _pricesInfo(OffsetDateTime applicationDate, Integer productId, Integer brandId) {
        ResponsePricesInfo response = calculatePriceUseCase.callToPricesInfo(applicationDate.toLocalDateTime(),productId,brandId);
        return ResponseEntity.ok().body(priceRestMapper.toResponsePricesInfoDto(response));
    }
}
