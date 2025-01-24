package com.inditex.brandcore.infrastructure.repository;

import com.inditex.brandcore.infrastructure.persistence.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * The interface Price jpa repository.
 */
@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity,Integer> {


    /**
     * Find highest priority price price entity.
     *
     * @param applicationDate the application date
     * @param productId       the product id
     * @param brandId         the brand id
     * @return the price entity
     */
    @Query("SELECT p FROM PriceEntity p " +
            "WHERE :applicationDate >= p.startDate AND :applicationDate <= p.endDate " +
            "AND p.productId = :productId " +
            "AND p.brand.id = :brandId " +
            "AND p.priority = (SELECT MAX(p2.priority) FROM PriceEntity p2 " +
            "WHERE :applicationDate >= p2.startDate AND :applicationDate <= p2.endDate " +
            "AND p2.productId = :productId " +
            "AND p2.brand.id = :brandId)")
    PriceEntity findHighestPriorityPrice( @Param("applicationDate") LocalDateTime applicationDate,
                                          @Param("productId") Integer productId,
                                          @Param("brandId") Integer brandId);
}
