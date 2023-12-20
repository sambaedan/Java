package com.rest.rest.repository;

import com.rest.rest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderRepo extends JpaRepository<Order,Long> {
    @Query(value = "SELECT a.* FROM orders a",nativeQuery = true)
    List<Map<String, Object>> getAllOrder();

    @Query(value = "SELECT a.* FROM orders WHERE a.id = ?1",nativeQuery = true)
    Map<String, Object> getOrderById();
}
