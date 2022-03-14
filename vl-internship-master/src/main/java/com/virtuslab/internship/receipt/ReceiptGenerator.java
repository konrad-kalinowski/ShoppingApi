package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.discount.Grains15PercentDiscount;
import com.virtuslab.internship.discount.TenPercentDiscount;
import com.virtuslab.internship.product.ProductDb;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ReceiptGenerator {

    private final ProductDb productDb;

    @Autowired
    public ReceiptGenerator(ProductDb productDb) {
        this.productDb = productDb;
    }


    public Receipt generate(Basket basket) {
        return getReceipt(basket);
    }

    private Receipt getReceipt(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();

        for (var productOrder : basket.getProductOrders()) {
            receiptEntries.add(new ReceiptEntry(productDb.getProduct(productOrder.name()), productOrder.quantity()));
        }
        var receipt = new Receipt(receiptEntries);
        var discount = new Grains15PercentDiscount();
        TenPercentDiscount tenPercentDiscount = new TenPercentDiscount();
        var receiptAfterDiscount = discount.apply(receipt);
        return tenPercentDiscount.apply(receiptAfterDiscount);
    }
}
