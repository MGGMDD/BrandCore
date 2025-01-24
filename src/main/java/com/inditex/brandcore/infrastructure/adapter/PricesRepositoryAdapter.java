package com.inditex.brandcore.infrastructure.adapter;

import com.inditex.brandcore.application.exception.PriceNotFoundException;
import com.inditex.brandcore.domain.model.Price;
import com.inditex.brandcore.domain.ports.PricesRepository;
import com.inditex.brandcore.infrastructure.mappers.PriceMapper;
import com.inditex.brandcore.infrastructure.persistence.PriceEntity;
import com.inditex.brandcore.infrastructure.repository.PriceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The type Prices repository adapter.
 */
@Component
public class PricesRepositoryAdapter implements PricesRepository {
    private final PriceJpaRepository priceJpaRepository;
    private final PriceMapper priceMapper;

    /**
     * Instantiates a new Prices repository adapter.
     *
     * @param priceJpaRepository the price jpa repository
     * @param priceMapper        the price mapper
     */
    public PricesRepositoryAdapter(PriceJpaRepository priceJpaRepository, PriceMapper priceMapper) {
        this.priceJpaRepository = priceJpaRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public Price findPriceByDate(LocalDateTime applicationDate, Integer productId, Integer brandId) {
       return priceJpaRepository.findHighestPriorityPrice(applicationDate, productId, brandId)
                .map(priceMapper::toPrice)
                .orElseThrow(PriceNotFoundException::new);
    }
}
