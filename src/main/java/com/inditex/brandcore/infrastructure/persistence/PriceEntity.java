package com.inditex.brandcore.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private String startDate;

    @Column( name = "END_DATE")
    private String endDate;

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