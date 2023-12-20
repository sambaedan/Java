package com.rest.rest.controller;

import com.rest.rest.model.Product;
import com.rest.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping (value = "/product")
public class ProductController {
   @Autowired
   private ProductService productservice;

   @PostMapping("/")
   public ResponseEntity<?> createProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.ok().body(productservice.createProduct(product));
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseEntity.status(500).body("Error");
        }

   }

   @GetMapping("/")
    public List<Product> getAllProducts(){
       return productservice.getAllProducts();
   }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productservice.getProductById(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productservice.UpdateProduct(id, productDetails);
    }

    @DeleteMapping("/")
    public String deleteAllProducts() {
        productservice.deleteAllProducts();
        return "All users have been deleted successfully.";
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productservice.deleteProduct(id);
    }

    
}
