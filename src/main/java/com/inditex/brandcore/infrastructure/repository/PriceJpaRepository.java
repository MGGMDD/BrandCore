package com.inditex.brandcore.infrastructure.repository;

import com.inditex.brandcore.infrastructure.persistence.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The interface Price jpa repository.
 */
@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Integer> {


    /**
     * Find highest priority price optional.
     *
     * @param applicationDate the application date
     * @param productId       the product id
     * @param brandId         the brand id
     * @return the optional
     */
    @Query("SELECT p1 FROM PriceEntity p1 " +
            "WHERE :applicationDate BETWEEN p1.startDate AND p1.endDate " +
            "AND p1.productId = :productId " +
            "AND p1.brand.id = :brandId " +
            "AND p1.priority = (SELECT MAX(p2.priority) FROM PriceEntity p2 " +
            "WHERE :applicationDate BETWEEN p2.startDate AND p2.endDate " +
            "AND p2.productId = :productId " +
            "AND p2.brand.id = :brandId)")
    Optional<PriceEntity> findHighestPriorityPrice(@Param("applicationDate") LocalDateTime applicationDate,
                                                   @Param("productId") Integer productId,
                                                   @Param("brandId") Integer brandId);
}
