package com.inditex.brandcore.infrastructure.rest;


import com.inditex.brandcore.infrastructure.rest.data.ResponsePricesInfoDto;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

public class PriceController  implements PricesApi{

    @Override
    public ResponseEntity<ResponsePricesInfoDto> _pricesInfo(OffsetDateTime applicationDate, Integer productId, Integer brandId) {
        return null;
    }
}
