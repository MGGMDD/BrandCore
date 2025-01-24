package com.inditex.brandcore.domain.ports;

import com.inditex.brandcore.domain.model.Brand;

/**
 * The interface Brand repository.
 */
public interface BrandRepository {
    /**
     * Find by id brand.
     *
     * @param integer the integer
     * @return the brand
     */
    Brand findById(Integer integer);
}
