package com.razif.order.service;

import com.razif.order.entity.Order;
import com.razif.order.repository.OrderRepository;
import com.razif.order.vo.Product;
import com.razif.order.vo.ResponseTemplate;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Order> getAll(){
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id){
        return orderRepository.findById(id).get();

    }
    public void insert(Order order){
        orderRepository.save(order);
    }
    @Transactional
    public void update(Long orderId,Integer jumlah,String tanggal, String status){
        Order order = orderRepository.findById(orderId).orElseThrow
                (()
                        -> new IllegalStateException("Order Tidak ada"));
        if(jumlah != null){
            order.setJumlah(jumlah);
        }
        if(tanggal != null && tanggal.length()>0
                && !Objects.equals(order.getTanggal(), tanggal)){
            order.setTanggal(tanggal);
        }
        if(status != null && status.length()>0
                && !Objects.equals(order.getStatus(), status)){
            order.setStatus(status);
        }
    }
    public void delete(Long id){
        orderRepository.deleteById(id);
    }

    public ResponseTemplate getOrderWithProductById(Long id){
        ResponseTemplate responseTemplate = new ResponseTemplate();
        Order order = getOrderById(id);
        Product product = restTemplate.getForObject("http://localhost:9001/api/v1/product/" +order.getProductId(), Product.class);
        responseTemplate.setOrder(order);
        responseTemplate.setProduct(product);
        return responseTemplate;
    }

}