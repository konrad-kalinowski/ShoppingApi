package com.virtuslab.internship.receipt;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.order.ProductOrder;
import com.virtuslab.internship.product.ProductDb;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptGeneratorTest {

    @Test
    void testReceiptGeneration() {
        var productDb = new ProductDb();
        ProductOrder milkOrder = new ProductOrder("Milk", 1);
        ProductOrder breadOrder = new ProductOrder("Bread", 1);
        ProductOrder appleOrder = new ProductOrder("Apple", 1);
        var milk = productDb.getProduct("Milk");
        var bread = productDb.getProduct("Bread");
        var apple = productDb.getProduct("Apple");
        var expectedTotalPrice = milk.price().add(bread.price()).add(apple.price());
        var cart = new Basket(List.of(milkOrder, breadOrder, appleOrder));

        var receiptGenerator = new ReceiptGenerator(productDb);
        var receipt = receiptGenerator.generate(cart);
        assertNotNull(receipt);
        assertEquals(3, receipt.entries().size());
        assertEquals(expectedTotalPrice, receipt.totalPrice());
        assertEquals(0, receipt.discounts().size());
    }

}