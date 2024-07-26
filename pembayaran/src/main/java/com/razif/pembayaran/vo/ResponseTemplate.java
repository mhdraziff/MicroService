package com.razif.pembayaran.vo;

import com.razif.pembayaran.entity.Pembayaran;

import java.security.PublicKey;

public class ResponseTemplate {
    Pembayaran pembayaran;
    Order order;


    public ResponseTemplate(){

    }

    public ResponseTemplate(Pembayaran pembayaran, Order order) {
        this.pembayaran = pembayaran;
        this.order = order;

    }
    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public Order getOrder() {
        return order;
    }
    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }
    public void setOrder(Order order) {
        this.order = order;
    }



}