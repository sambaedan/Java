package com.rest.rest.pojo;

import com.rest.rest.model.Product;
import com.rest.rest.model.User;
import lombok.Data;



@Data
public class OrderPojo {
    private long id;
    Product product;
    User user;
}
