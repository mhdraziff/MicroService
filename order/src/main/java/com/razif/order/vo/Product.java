package com.razif.order.vo;


public class Product {
    private Long id;
    private String kode;
    private String nama;
    private String satuan;
    private double harga;

    public Product() {
    }

    public Product(Long id, String kode, String nama, String satuan, double harga) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.satuan = satuan;
        this.harga = harga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", kode=" + kode + ", nama=" + nama + ", satuan=" + satuan + ", harga=" + harga + '}';
    }

}