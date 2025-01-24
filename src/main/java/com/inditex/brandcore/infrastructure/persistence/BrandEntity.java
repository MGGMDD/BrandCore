package com.inditex.brandcore.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The type Brand entity.
 */
@Entity
@Table(name="BRAND")
@Getter
@Setter
public class BrandEntity {
    @Id
    @Column(name = "BRAND_ID", nullable = false)
    private Integer id;

    @Column(name = "BRAND_NAME", nullable = false)
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private
    Set<PriceEntity> prices = new LinkedHashSet<>();
}
