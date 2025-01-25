package com.inditex.brandcore.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * The type Price entity.
 */
@Entity
@Table(name="PRICES")
@Getter
@Setter
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_LIST", nullable = false, updatable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private BrandEntity brand;

    @Column( name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column( name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column( name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column( name = "PRICE", nullable = false)
    private Double price;

    @Column( name = "PRIORITY", nullable = false)
    private Integer priority;

    @Column( name = "CURR", nullable = false, length = 3)
    private String curr;

}