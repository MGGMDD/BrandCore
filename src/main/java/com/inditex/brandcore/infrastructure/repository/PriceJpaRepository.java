package com.inditex.brandcore.infrastructure.repository;

import com.inditex.brandcore.infrastructure.persistence.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The interface Price jpa repository.
 */
@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Integer> {


    /**
     * Find highest priority price list.
     *
     * @param applicationDate the application date
     * @param productId       the product id
     * @param brandId         the brand id
     * @return the list
     */
    @Query(
            value =
                    "select p from PriceEntity p where p.productId = :productId and p.brand.id = :brandId and :applicationDate between p.startDate and p.endDate")
    List<PriceEntity> findHighestPriorityPrice(
            @Param("applicationDate") LocalDateTime applicationDate,
            @Param("productId") Integer productId,
            @Param("brandId") Integer brandId);


}
