package com.razif.pegawai.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_pegawai")
public class Pegawai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int nip;
    private String nama;
    private double gaji;

    public Pegawai(){
    }
    public Pegawai(Long id, Long productId, int nip, String nama, double gaji){
        this.id = id;
        this.productId = productId;
        this.nip = nip;
        this.nama = nama;
        this.gaji = gaji;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId ;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public double getGaji() {
        return gaji;
    }

    public void setTotal(double gaji) {
        this.gaji = gaji;
    }
    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", productId=" + productId + ", nip=" + nip + ", nama=" + nama +", gaji=" + gaji + '}';
    }

}