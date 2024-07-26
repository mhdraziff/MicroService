package com.razif.product.service;

import com.razif.product.entity.Product;
import com.razif.product.repository.ProductRepository;
import java.util.List;
import java.util.Objects;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public Product getProduct(Long id){
        return productRepository.findById(id).get();
    }


    public Product getProductById(Long productId){
        return productRepository.findById(productId).get();

    }
    public void insert(Product product){
        productRepository.save(product);
    }
    @Transactional
    public void update(Long productId, String kode, String nama, String satuan, double harga){
        Product product = productRepository.findById(productId)
                .orElseThrow(
                        () -> new IllegalStateException("Product Tidak ada")
                );
        if(kode != null && kode.length()>0
                && !Objects.equals(product.getKode(), kode)){
            product.setKode(kode);
        }
        if(nama != null && nama.length()>0
                && !Objects.equals(product.getNama(), nama)){
            product.setNama(nama);
        }
        if(satuan != null && satuan.length()>0
                && !Objects.equals(product.getSatuan(), satuan)){
            product.setSatuan(satuan);
        }
        if(harga != 0
                && !Objects.equals(product.getHarga(), harga)){
            product.setHarga(harga);
        }
    }

    public void delete(Long productId){
        productRepository.deleteById(productId);
    }
}