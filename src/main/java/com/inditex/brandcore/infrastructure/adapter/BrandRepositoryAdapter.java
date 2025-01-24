package com.inditex.brandcore.infrastructure.adapter;

import com.inditex.brandcore.domain.model.Brand;
import com.inditex.brandcore.domain.ports.BrandRepository;
import com.inditex.brandcore.infrastructure.mappers.BrandMapper;
import com.inditex.brandcore.infrastructure.persistence.BrandEntity;
import com.inditex.brandcore.infrastructure.repository.BrandJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

/**
 * The type Brand repository adapter.
 */
@Component
public class BrandRepositoryAdapter implements BrandRepository {
    private final BrandJpaRepository brandJpaRepository;
    private final BrandMapper brandMapper;

    /**
     * Instantiates a new Brand repository adapter.
     *
     * @param brandMapper        the brand mapper
     * @param brandJpaRepository the brand jpa repository
     */
    public BrandRepositoryAdapter(BrandMapper brandMapper, BrandJpaRepository brandJpaRepository) {
        this.brandMapper = brandMapper;
        this.brandJpaRepository = brandJpaRepository;
    }

    @Override
    public Brand findById(Integer integer) {
        return brandJpaRepository.findById(integer).stream().map(brandMapper::toBrand).findAny().orElseThrow(EntityNotFoundException::new);
    }
}
