package com.virtuslab.internship.discount;

import com.virtuslab.internship.product.Product;
import com.virtuslab.internship.receipt.Receipt;

import java.math.BigDecimal;

public class Grains15PercentDiscount {

    public static String NAME = "15PercentDiscount";

    public Receipt apply(Receipt receipt) {
        if (shouldApply(receipt)) {
            var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(0.85));
            var discounts = receipt.discounts();
            discounts.add(NAME);
            return new Receipt(receipt.entries(), discounts, totalPrice);
        }
        return receipt;
    }

    private boolean shouldApply(Receipt receipt) {
        int grainProductsCounter = 0;
        for (var receiptEntry : receipt.entries()) {
            if(receiptEntry.product().type().equals(Product.Type.GRAINS)){
                grainProductsCounter += receiptEntry.quantity();
            }
        }
        return grainProductsCounter >= 3;
    }
}
