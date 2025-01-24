package com.inditex.brandcore.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * The type Price entity.
 */
@Entity
@Getter
@Setter
@Table(name = "PRICES",
        indexes = {@Index(name = "FK_CADENA_INDEX_6", columnList = "BRAND_ID")})
public class PriceEntity {
    @Id
    @Column(name = "PRICE_LIST", nullable = false)
    private Integer pricesId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private BrandEntity brand;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "CURR", nullable = false, length = 3)
    private String curr;

}