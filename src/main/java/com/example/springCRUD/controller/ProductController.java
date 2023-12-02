package com.example.springCRUD.controller;

import com.example.springCRUD.model.Product;
import com.example.springCRUD.model.ResponseData;
import com.example.springCRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public ResponseData getProductAll() {
        List<Product> productList = new ArrayList<>();
        productList = productService.getAll();
        return new ResponseData(HttpStatus.OK.toString(),"Successfully",productList);
    }

    @GetMapping("/get/{id}")
    public ResponseData getProduceById(@PathVariable("id") Long id) {
        Product product = new Product();
        product = productService.getProductById(id);
        return new ResponseData(HttpStatus.OK.toString(),"Successfully",product);
    }

    @PostMapping("/create")
    public ResponseData createProduct(@RequestBody Product product) {
        Product productCreated = new Product();
        if(product != null && product.toString().length()>0){
            productCreated = productService.save(product);
            return new ResponseData(HttpStatus.OK.toString(),"Successfully",productCreated);
        }
        else {
            return new ResponseData(HttpStatus.BAD_REQUEST.toString(),"pls add Product data",productCreated);
        }
    }

    @PutMapping("/update")
    public ResponseData updateProduct(@RequestBody Product product) {
        if(product.toString().contains("id")|| product.getId() != null){
            Product productUpdate = new Product();
            productUpdate = productService.save(product);
            return new ResponseData(HttpStatus.OK.toString(),"Successfully",productUpdate);
        }else {
            return new ResponseData(HttpStatus.BAD_REQUEST.toString(),"productId is Null",null);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseData deleteProduct(@PathVariable("id") Long id) {
        if(id != null){
            productService.delete(id);
            return new ResponseData(HttpStatus.OK.toString(),"Delete Product Successfully",null);
        }
       else {
            return new ResponseData(HttpStatus.BAD_REQUEST.toString(),"productId is Null",null);
        }
    }
}
