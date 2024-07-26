package com.razif.product.controller;

import com.razif.product.entity.Product;
import com.razif.product.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping(path = "{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }
    @PostMapping
    public void insert(@RequestBody Product product){
        productService.insert(product);
    }

    @DeleteMapping(path = "{productId}")
    public void delete(@PathVariable ("productId") Long productId){
        productService.delete(productId);
    }

    @PutMapping(path = "{productId}")
    public void update(@PathVariable ("productId") Long productId,
                       @RequestParam(required = false) String kode,
                       @RequestParam(required = false) String nama,
                       @RequestParam(required = false) String satuan,
                       @RequestParam(required = false) double harga){
        productService.update(productId, kode, nama, satuan, harga);
    }

}