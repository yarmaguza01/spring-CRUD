package com.example.springCRUD.controller;

import com.example.springCRUD.model.Product;
import com.example.springCRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getProductAll() {
        List<Product> productList = new ArrayList<>();
        productList = productService.getAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProduceById(@PathVariable("id") Long id) {
        Product product = new Product();
        product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product productCreated = new Product();
        if(product != null || !product.toString().isEmpty()){
            productCreated = productService.save(product);
            return new ResponseEntity<Product>(productCreated,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("productData is null",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateProduct(@RequestBody Product product) {
        if(product.toString().contains("id")|| product.getId() != null){
            productService.save(product);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("productId is Null",HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Long id) {
        if(id != null){
            productService.delete(id);
            return new ResponseEntity<>("Delete Product Successfully",HttpStatus.OK);
        }
       else {
            return new ResponseEntity<>("productId is Null",HttpStatus.BAD_REQUEST);
        }
    }
}
