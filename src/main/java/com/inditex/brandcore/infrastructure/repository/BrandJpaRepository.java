package com.inditex.brandcore.infrastructure.repository;

import com.inditex.brandcore.infrastructure.persistence.BrandEntity;
import com.inditex.brandcore.infrastructure.persistence.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Brand jpa repository.
 */
@Repository
public interface BrandJpaRepository extends JpaRepository<BrandEntity,Integer> {

    Optional <BrandEntity> findById(Integer id);
}
