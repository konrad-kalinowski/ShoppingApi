package com.virtuslab.internship.basket;

import com.virtuslab.internship.order.ProductOrder;
import com.virtuslab.internship.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<ProductOrder> productOrders;

    public Basket() {
        productOrders = new ArrayList<>();
    }

    public Basket(List<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public List<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }
}
