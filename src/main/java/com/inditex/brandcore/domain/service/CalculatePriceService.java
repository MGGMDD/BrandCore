package com.inditex.brandcore.domain.service;

import com.inditex.brandcore.application.usecases.CalculatePriceUseCase;
import com.inditex.brandcore.domain.model.Brand;
import com.inditex.brandcore.domain.model.Price;
import com.inditex.brandcore.domain.model.response.ResponsePricesInfo;
import com.inditex.brandcore.domain.ports.BrandRepository;
import com.inditex.brandcore.domain.ports.PricesRepository;
import com.inditex.brandcore.infrastructure.persistence.PriceEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Calculate price service.
 */
@Service
@Slf4j
public class CalculatePriceService implements CalculatePriceUseCase {
    private final PricesRepository pricesRepository;
    private final BrandRepository brandRepository;

    public CalculatePriceService(PricesRepository pricesRepository, BrandRepository brandRepository) {
        this.pricesRepository = pricesRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public ResponsePricesInfo callToPricesInfo(LocalDateTime applicationDate, Integer productId, Integer brandId) {
       // Brand brand = brandRepository.findById(brandId);
       // log.info("Se procede a obtener la informacion sobre la cadena {}",brand.getBrandName());
        List<Price> price = pricesRepository.findPriceByDate(applicationDate, productId, brandId);
        return buildResponse(price, applicationDate);
    }

    private ResponsePricesInfo buildResponse(List<Price> price, LocalDateTime applicationDate) {
        return ResponsePricesInfo.builder()
                .priceList(price.get(0).getPricesList())
                .finalPrice(price.get(0).getPrice())
                .brandId(price.get(0).getBrand().getId())
                .productId(price.get(0).getProductId())
                .applicationDate(applicationDate).build();
    }
}
