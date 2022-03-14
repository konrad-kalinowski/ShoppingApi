package com.virtuslab.internship;

import com.virtuslab.internship.product.ProductDb;
import com.virtuslab.internship.receipt.ReceiptGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShoppingAppConfig {
    @Bean
    public ProductDb getProductDB() {
        return new ProductDb();
    }

    @Bean
    public ReceiptGenerator getReceiptGenerator(ProductDb productDB) {
        return new ReceiptGenerator(productDB);
    }

}
