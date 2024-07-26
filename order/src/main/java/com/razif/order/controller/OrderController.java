package com.razif.order.controller;

import com.razif.order.entity.Order;
import com.razif.order.service.OrderService;
import java.util.List;

import com.razif.order.vo.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }
    @PostMapping
    public void insert(@RequestBody Order order){
        orderService.insert(order);
    }

    @GetMapping(path = "{id}")
    public Order getOrderById(@PathVariable("id") Long Id){
        return orderService.getOrderById(Id);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable ("id") Long Id){
        orderService.delete(Id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable ("id") Long id,
                       @RequestParam(required = false) Integer jumlah,
                       @RequestParam(required = false) String tanggal,
                       @RequestParam(required = false) String status){
        orderService.update(id, jumlah, tanggal, status);
    }

    @GetMapping(path = "/product/{id}")
    public ResponseTemplate getOrderWithProductById(@PathVariable("id") Long id){
        return orderService.getOrderWithProductById(id);
    }

}