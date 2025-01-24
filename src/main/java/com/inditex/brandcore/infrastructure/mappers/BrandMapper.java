package com.inditex.brandcore.infrastructure.mappers;

import com.inditex.brandcore.domain.model.Brand;
import com.inditex.brandcore.infrastructure.persistence.BrandEntity;
import org.mapstruct.Mapper;

/**
 * The interface Brand mapper.
 */
@Mapper
public interface BrandMapper {
    /**
     * To brand entity brand entity.
     *
     * @param brand the brand
     * @return the brand entity
     */
    BrandEntity toBrandEntity(Brand brand);

    /**
     * To brand brand.
     *
     * @param brandEntity the brand entity
     * @return the brand
     */
    Brand toBrand(BrandEntity brandEntity);
}
