package com.rest.rest.service;

import com.rest.rest.repository.OrderRepo;
import com.rest.rest.repository.UserRepo;

import java.util.List;
import java.util.Map;

public class OrderService {

    private OrderRepo orderrepo;
    public List<Map<String, Object>> getAllOrder() {
        return orderrepo.getAllOrder();
    }
    public Map<String, Object> getOrderByid(long id) {
        return orderrepo.getOrderById();
    }

    public void deleteAllOrder() {
        orderrepo.deleteAll();
    }

    public void deleteOrderById(long id) {
        orderrepo.deleteById(id);
    }
}
