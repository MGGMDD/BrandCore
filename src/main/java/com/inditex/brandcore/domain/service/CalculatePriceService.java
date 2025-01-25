package com.inditex.brandcore.domain.service;

import com.inditex.brandcore.application.usecases.CalculatePriceUseCase;
import com.inditex.brandcore.domain.model.Brand;
import com.inditex.brandcore.domain.model.Price;
import com.inditex.brandcore.domain.model.response.ResponsePricesInfo;
import com.inditex.brandcore.domain.ports.BrandRepository;
import com.inditex.brandcore.domain.ports.PricesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        log.info("Getting information about the brand {}", brand.getBrandName());
        Price price = pricesRepository.findPriceByDate(applicationDate, productId, brandId);
        return buildResponse(price, applicationDate);
    }

    private ResponsePricesInfo buildResponse(Price price, LocalDateTime applicationDate) {
        log.info("Building a response object.");
        return ResponsePricesInfo.builder()
                .priceList(price.getId())
                .finalPrice(price.getPrice())
                .brandId(price.getBrand().getId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .productId(price.getProductId()).build();
    }
}
