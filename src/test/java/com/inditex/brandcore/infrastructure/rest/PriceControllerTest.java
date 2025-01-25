package com.inditex.brandcore.infrastructure.rest;

import com.inditex.brandcore.application.usecases.CalculatePriceUseCase;
import com.inditex.brandcore.constants.TestConstants;
import com.inditex.brandcore.domain.model.Brand;
import com.inditex.brandcore.domain.model.Price;
import com.inditex.brandcore.infrastructure.mappers.PriceRestMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

/**
 * The type Price controller test.
 */
@SpringBootTest
public class PriceControllerTest {

    @Autowired
    private PriceController priceController;

    /**
     * The Price 1.
     */
    Price price1, /**
     * The Price 2.
     */
    price2, /**
     * The Price 3.
     */
    price3, /**
     * The Price 4.
     */
    price4, /**
     * The Price 5.
     */
    price5;
    /**
     * The Application date 1.
     */
    LocalDateTime applicationDate1, /**
     * The Application date 2.
     */
    applicationDate2, /**
     * The Application date 3.
     */
    applicationDate3, /**
     * The Application date 4.
     */
    applicationDate4, /**
     * The Application date 5.
     */
    applicationDate5;
    /**
     * The Brand.
     */
    Brand brand;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        applicationDate1 = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
        applicationDate2 = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
        applicationDate3 = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
        applicationDate4 = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
        applicationDate5 = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        brand = buildBrand();
        price1 = buildPrice(LocalDateTime.of(2020, 6, 14, 0, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 35.5, TestConstants.PRIORITY_O);
        price2 = buildPrice(LocalDateTime.of(2020, 6, 14, 15, 0, 0), LocalDateTime.of(2020, 6, 14, 18, 30, 0), 25.45, TestConstants.PRIORITY_1);
        price3 = buildPrice(LocalDateTime.of(2020, 6, 15, 0, 0, 0), LocalDateTime.of(2020, 6, 15, 11, 0, 0), 30.5, TestConstants.PRIORITY_1);
        price4 = buildPrice(LocalDateTime.of(2020, 6, 15, 16, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59), 38.95, TestConstants.PRIORITY_1);

    }

    /**
     * Call to prices info with application date 1 test.
     */
    @Test
    void callToPricesInfoWithApplicationDate1Test() {
        var response = priceController._pricesInfo(applicationDate1, TestConstants.PRODUCT_ID, TestConstants.BRAND_ID);
        assertNotNull(response);
        assertEquals(price1.getPrice(), Objects.requireNonNull(response.getBody()).getFinalPrice());
        assertNotNull(response);
        assertEquals(TestConstants.PRODUCT_ID, Objects.requireNonNull(response.getBody()).getProductId());
        assertEquals(TestConstants.BRAND_ID, Objects.requireNonNull(response.getBody()).getBrandId());
        assertEquals(price1.getStartDate(), Objects.requireNonNull(response.getBody()).getStartDate());
        assertEquals(price1.getEndDate(), Objects.requireNonNull(response.getBody()).getEndDate());
    }

    /**
     * Call to prices info with application date 2 test.
     */
    @Test
    void callToPricesInfoWithApplicationDate2Test() {
        var response = priceController._pricesInfo(applicationDate2, TestConstants.PRODUCT_ID, TestConstants.BRAND_ID);
        assertNotNull(response);
        assertEquals(price2.getPrice(), Objects.requireNonNull(response.getBody()).getFinalPrice());
        assertNotNull(response);
        assertEquals(TestConstants.PRODUCT_ID, Objects.requireNonNull(response.getBody()).getProductId());
        assertEquals(TestConstants.BRAND_ID, Objects.requireNonNull(response.getBody()).getBrandId());
        assertEquals(price2.getStartDate(), Objects.requireNonNull(response.getBody()).getStartDate());
        assertEquals(price2.getEndDate(), Objects.requireNonNull(response.getBody()).getEndDate());
    }

    /**
     * Call to prices info with application date 3 test.
     */
    @Test
    void callToPricesInfoWithApplicationDate3Test() {
        var response = priceController._pricesInfo(applicationDate3, TestConstants.PRODUCT_ID, TestConstants.BRAND_ID);
        assertNotNull(response);
        assertEquals(price1.getPrice(), Objects.requireNonNull(response.getBody()).getFinalPrice());
        assertNotNull(response);
        assertEquals(TestConstants.PRODUCT_ID, Objects.requireNonNull(response.getBody()).getProductId());
        assertEquals(TestConstants.BRAND_ID, Objects.requireNonNull(response.getBody()).getBrandId());
        assertEquals(price1.getStartDate(), Objects.requireNonNull(response.getBody()).getStartDate());
        assertEquals(price1.getEndDate(), Objects.requireNonNull(response.getBody()).getEndDate());
    }

    /**
     * Call to prices info with application date 4 test.
     */
    @Test
    void callToPricesInfoWithApplicationDate4Test() {
        var response = priceController._pricesInfo(applicationDate4, TestConstants.PRODUCT_ID, TestConstants.BRAND_ID);
        assertNotNull(response);
        assertEquals(price3.getPrice(), Objects.requireNonNull(response.getBody()).getFinalPrice());
        assertNotNull(response);
        assertEquals(TestConstants.PRODUCT_ID, Objects.requireNonNull(response.getBody()).getProductId());
        assertEquals(TestConstants.BRAND_ID, Objects.requireNonNull(response.getBody()).getBrandId());
        assertEquals(price3.getStartDate(), Objects.requireNonNull(response.getBody()).getStartDate());
        assertEquals(price3.getEndDate(), Objects.requireNonNull(response.getBody()).getEndDate());
    }

    /**
     * Call to prices info with application date 5 test.
     */
    @Test
    void callToPricesInfoWithApplicationDate5Test() {
        var response = priceController._pricesInfo(applicationDate5, TestConstants.PRODUCT_ID, TestConstants.BRAND_ID);
        assertNotNull(response);
        assertEquals(price4.getPrice(), Objects.requireNonNull(response.getBody()).getFinalPrice());
        assertNotNull(response);
        assertEquals(TestConstants.PRODUCT_ID, Objects.requireNonNull(response.getBody()).getProductId());
        assertEquals(TestConstants.BRAND_ID, Objects.requireNonNull(response.getBody()).getBrandId());
        assertEquals(price4.getStartDate(), Objects.requireNonNull(response.getBody()).getStartDate());
        assertEquals(price4.getEndDate(), Objects.requireNonNull(response.getBody()).getEndDate());
    }

    private Brand buildBrand() {
        return Brand.builder().id(TestConstants.BRAND_ID).brandName(TestConstants.ZARA_BRAND).build();
    }

    private Price buildPrice(LocalDateTime startDate, LocalDateTime endDate, Double price, Integer priority) {
        return Price.builder()
                .startDate(startDate)
                .endDate(endDate)
                .productId(TestConstants.PRODUCT_ID)
                .brand(brand)
                .price(price)
                .id(1)
                .curr(TestConstants.CURRENCY)
                .priority(priority).build();
    }

}
