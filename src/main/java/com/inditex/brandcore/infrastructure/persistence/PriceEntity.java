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
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private BrandEntity brand;

    @Column( name = "START_DATE")
    private LocalDateTime startDate;

    @Column( name = "END_DATE")
    private LocalDateTime endDate;

    @Column( name = "PRICE_LIST")
    private String priceList;

    @Column( name = "PRODUCT_ID")
    private Integer productId;

    @Column( name = "PRICE")
    private Double price;

    @Column( name = "PRIORITY")
    private Integer priority;

    @Column( name = "CURR")
    private String curr;

}