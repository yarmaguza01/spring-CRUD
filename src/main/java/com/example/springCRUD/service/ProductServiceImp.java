package com.example.springCRUD.service;

import com.example.springCRUD.model.Product;
import com.example.springCRUD.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> getAll(){
        return (List<Product>) repository.findAll();
    }
    @Override
    public Product getProductById(Long id) {
       return repository.findProductById(id);
    }

    @Override
    public Product save(Product product){
        return repository.save(product);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}
