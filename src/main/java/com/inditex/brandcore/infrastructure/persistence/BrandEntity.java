package com.inditex.brandcore.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Brand entity.
 */
@Entity
@Table(name="BRAND")
@Getter
@Setter
public class BrandEntity {
    @Id
    @Column( name = "BRAND_ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( name = "BRAND_NAME", nullable = false, length = 255)
    private String brandName;
}
