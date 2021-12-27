package com.example.l3.service;

import com.example.l3.entity.Product;
import com.example.l3.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService
{
    private final ProductRepository productRepository;


    public void save(Product product) {
        productRepository.save(product);
    }

    public void edit(Product product){
        productRepository.edit(product);
    }

    public Product findById(int id)
    {
        return productRepository.findById(id).orElse(new Product());
    }

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public long count(){
        return productRepository.count();
    }

    public void deleteById(int id)
    {
        productRepository.deleteById(id);
    }

    public Product getRandomProduct(){
        return Product.builder()
                .title("Error")
                .build();
    }
}
