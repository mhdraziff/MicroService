package com.razif.order.vo;

import com.razif.order.entity.Order;

public class ResponseTemplate {
    Order order;
    Product product;

    public ResponseTemplate(){

    }

    public ResponseTemplate(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}