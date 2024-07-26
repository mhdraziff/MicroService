package com.razif.pegawai.vo;

import com.razif.pegawai.entity.Pegawai;

public class ResponseTemplate {
    Pegawai pegawai;
    Product product;

    public ResponseTemplate(){

    }

    public ResponseTemplate(Pegawai pegawai, Pegawai pegawai) {
        this.pegawai = pegawai;
        this.product = product;
    }

    public Pegawai getOrder() {
        return pegawai;
    }

    public Product getProduct() {
        return product;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}