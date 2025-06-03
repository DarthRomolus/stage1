package com.example.stage1.controller;

import com.example.stage1.entity.Product;
import com.example.stage1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/products")
@RestController
public class ProductController {

    ProductService productService;


    public ResponseEntity<String> check(){
        String products = productService.getAllProducts().toString();
        return ResponseEntity.ok(products);
    }

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping
    Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product){
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }


}

