package com.inditex.brandcore.domain.service;

import com.inditex.brandcore.constants.TestConstants;
import com.inditex.brandcore.domain.model.Brand;
import com.inditex.brandcore.domain.model.Price;
import com.inditex.brandcore.domain.ports.BrandRepository;
import com.inditex.brandcore.domain.ports.PricesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * The type Calculate prices service test.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CalculatePricesServiceTest {
    @InjectMocks
    private CalculatePriceService calculatePriceService;
    @Mock
    private PricesRepository pricesRepository;
    @Mock
    private BrandRepository brandRepository;
    /**
     * The Price.
     */
    Price price;
    /**
     * The Application date.
     */
    LocalDateTime applicationDate;
    /**
     * The Brand.
     */
    Brand brand;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        brand = buildBrand();
        price = buildPrice();
    }

    /**
     * Call to prices info test.
     */
    @Test
    void callToPricesInfoTest() {
        when(brandRepository.findById(any())).thenReturn(brand);
        when(pricesRepository.findPriceByDate(any(), any(),any())).thenReturn(price);
        var response = calculatePriceService.callToPricesInfo(applicationDate, TestConstants.PRODUCT_ID, TestConstants.BRAND_ID);
        assertEquals(response.getFinalPrice(), price.getPrice());
    }



    private Brand buildBrand() {
        return Brand.builder().id(TestConstants.BRAND_ID).brandName(TestConstants.ZARA_BRAND).build();
    }

    private Price buildPrice() {
        return Price.builder()
                .startDate(LocalDateTime.of(2020, 6, 14, 0, 0, 0))
                .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
                .productId(TestConstants.PRODUCT_ID)
                .brand(brand)
                .price(35.5)
                .id(1)
                .curr(TestConstants.CURRENCY)
                .priority(TestConstants.PRIORITY_O).build();
    }
}
