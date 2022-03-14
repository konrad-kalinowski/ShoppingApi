package com.virtuslab.internship;

import com.virtuslab.internship.basket.Basket;
import com.virtuslab.internship.receipt.Receipt;
import com.virtuslab.internship.receipt.ReceiptGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptController {

    private ReceiptGenerator receiptGenerator;

    @Autowired
    public ReceiptController(ReceiptGenerator receiptGenerator) {
        this.receiptGenerator = receiptGenerator;
    }

    @PostMapping("/receipt")
    Receipt calculateReceipt(@RequestBody Basket basket) {
        return receiptGenerator.generate(basket);
    }

}
