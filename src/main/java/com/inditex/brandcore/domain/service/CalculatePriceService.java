package com.inditex.brandcore.domain.service;

import com.inditex.brandcore.application.usecases.CalculatePriceUseCase;
import com.inditex.brandcore.domain.model.Brand;
import com.inditex.brandcore.domain.model.Price;
import com.inditex.brandcore.domain.model.response.ResponsePricesInfo;
import com.inditex.brandcore.domain.ports.BrandRepository;
import com.inditex.brandcore.domain.ports.PricesRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * The type Calculate price service.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CalculatePriceService implements CalculatePriceUseCase {
    private final PricesRepository pricesRepository;
    private final BrandRepository brandRepository;

    @Override
    public ResponsePricesInfo callToPricesInfo(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        Brand brand = brandRepository.findById(brandId);
        log.info("Se procede a obtener la informacion sobre la cadena {}",brand.getBrandName());
        Price price = pricesRepository.findPriceByDate(applicationDate, productId, brandId);
        return buildResponse(price, applicationDate);
    }

    private ResponsePricesInfo buildResponse(Price price, LocalDateTime applicationDate) {
        return ResponsePricesInfo.builder()
                .priceList(price.getPriceList())
                .finalPrice(price.getPrice())
                .brandId(price.getBrand().getId())
                .productId(price.getProductId())
                .applicationDate(applicationDate).build();
    }
}
