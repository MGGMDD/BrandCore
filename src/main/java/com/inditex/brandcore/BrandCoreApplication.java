package com.inditex.brandcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.inditex.infrastructure.persistence.entity")
public class BrandCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrandCoreApplication.class, args);
    }

}
