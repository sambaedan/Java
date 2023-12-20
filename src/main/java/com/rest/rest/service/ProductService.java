package com.rest.rest.service;

import com.rest.rest.model.Product;
import com.rest.rest.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

  public  Product createProduct(Product product)
  {
      return productRepo.save(product);
  }

  public List<Product> getAllProducts(){
      return productRepo.findAll();
  }

  public Product getProductById(Long id){
      Optional<Product> optionalProduct = productRepo.findById(id);
      return optionalProduct.orElse(null);
  }

  public Product UpdateProduct(Long id, Product productDetails){
      Optional<Product> product = productRepo.findById(id);
      if (product.isPresent()){
          Product a = product.get();
          a.setCategory(productDetails.getCategory());
          a.setDescription(productDetails.getDescription());
          a.setPrice(productDetails.getPrice());
          return productRepo.save(a);
      }
      return null;
  }
  public void deleteProduct(long id)
  {
      productRepo.deleteById(id);
  }

  public void deleteAllProducts() {
      productRepo.deleteAll();
    }
}
