package com.inditex.brandcore.infrastructure.adapter;

import com.inditex.brandcore.domain.model.Price;
import com.inditex.brandcore.domain.ports.PricesRepository;
import com.inditex.brandcore.infrastructure.mappers.PriceMapper;
import com.inditex.brandcore.infrastructure.persistence.PriceEntity;
import com.inditex.brandcore.infrastructure.repository.PriceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PricesRepositoryAdapter implements PricesRepository {
    private final PriceJpaRepository priceJpaRepository;
    private final PriceMapper priceMapper;

    public PricesRepositoryAdapter(PriceJpaRepository priceJpaRepository, PriceMapper priceMapper) {
        this.priceJpaRepository = priceJpaRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public Price findPriceByDate(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        PriceEntity entity =  priceJpaRepository.findHighestPriorityPrice(applicationDate,productId,brandId);
        return priceMapper.toPrice(entity);
    }
}
