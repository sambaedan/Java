package com.rest.rest.controller;

import com.rest.rest.pojo.OrderPojo;
import com.rest.rest.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private OrderService orderservice;
    @PostMapping("/")
    public void createOrder(@RequestBody OrderPojo orderpojo) {}

    @GetMapping("/")
    public List<Map<String,Object>> getAllOrder()
    {
        return orderservice.getAllOrder();
    }

    @GetMapping("/{id}")
    public Map<String,Object> getOrderById(@PathVariable long id)
    {
        return orderservice.getOrderByid(id);
    }

    @DeleteMapping("/")
    public String deleteAllOrder()
    {  orderservice.deleteAllOrder();
        return "All orders have been deleted successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteOrderId(@PathVariable long id)
    {
        orderservice.deleteOrderById(id);
        return id + "deleted successfully";
    }

}
