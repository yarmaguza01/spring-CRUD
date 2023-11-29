package com.example.springCRUD.service;

import com.example.springCRUD.model.Product;


import java.util.List;

public interface ProductService {

    public List<Product> getAll();
    public Product getProductById(Long id);
    public Product save(Product product);
    public void delete(Long id);
}
