package com.inditex.brandcore.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * The type Brand.
 */
@Getter
@Setter
@Builder
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String brandName;
}